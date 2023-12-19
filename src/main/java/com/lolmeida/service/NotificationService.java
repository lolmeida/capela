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
import jakarta.ws.rs.core.Response;
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
    @Channel("sms-consumer")
    Emitter<String> emitter;

    public Response sendTwilioMessage(String toPhoneNumber, String message) {
        Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());

        Message.
                creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(twilioConfiguration.getPhoneNumber()), message)
                .create();
        return Response.ok(String.format("Message %s sent to %s", message, toPhoneNumber)).build();
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

    @Incoming("kafka")
    public Response sendKafkaMessage(String message) {
        emitter.send(message);
        return Response.ok(String.format("Message %s sent.",message)).build();
    }
}
