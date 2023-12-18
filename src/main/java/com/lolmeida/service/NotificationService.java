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

import java.io.IOException;

@ApplicationScoped
public class NotificationService {

    @Inject
    TwilioConfiguration twilioConfiguration;
    @Inject
    SlackConfiguration slackConfiguration;

    public void sendTwilioMessage(String toPhoneNumber, String message) {
        Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());

        Message.
                creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(twilioConfiguration.getPhoneNumber()), message)
                .create();

        /*Message message1 = Message
                .creator(new PhoneNumber(String.format("whatsapp:%s", toPhoneNumber)), new PhoneNumber(String.format("whatsapp:%s",twilioConfiguration.getPhoneNumber())), message)
                .setMessagingServiceSid(twilioConfiguration.getMessagingServiceSid())
                .create();
        System.out.println(message1.getMessagingServiceSid());*/
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
}
