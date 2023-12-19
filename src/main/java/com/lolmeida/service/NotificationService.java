package com.lolmeida.service;

import com.lolmeida.config.SlackConfiguration;
import com.lolmeida.config.TwilioConfiguration;
import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.io.IOException;

@ApplicationScoped
public class NotificationService {

    @Inject
    TwilioConfiguration twilioConfiguration;
    @Inject
    SlackConfiguration slackConfiguration;

    @Inject
    @Channel("sms-notifications")
    Emitter<String> smsEmitter;

    public void sendTwilioMessage(String toPhoneNumber, String message) {
        Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());

        Message.
                creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(twilioConfiguration.getPhoneNumber()), message)
                .create();
    }

    public void sendSlackMessage(String channel, String messageText) {
        try {
            Slack.getInstance().methods(slackConfiguration.getSmsToken()).chatPostMessage(req -> req
                    .channel(channel)
                    .text(messageText));
        } catch (IOException | SlackApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Incoming("sms-notifications")
    public void sendKafkaMessage(String message) {
        smsEmitter.send(message);
    }
}
