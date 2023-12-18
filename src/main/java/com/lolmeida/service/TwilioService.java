package com.lolmeida.service;

import com.lolmeida.config.TwilioConfiguration;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TwilioService {

    @Inject
    TwilioConfiguration twilioConfiguration;

    public void sendMessage(String toPhoneNumber, String message) {
        Twilio
                .init(
                        twilioConfiguration.getAccountSid(),
                        twilioConfiguration.getAuthToken());

        Message
                .creator(
                        new PhoneNumber(toPhoneNumber),
                        new PhoneNumber(twilioConfiguration.getPhoneNumber()),
                        message)
                .create();
    }
}
