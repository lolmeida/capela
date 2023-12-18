package com.lolmeida.config;


import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Data;

@Data
@ApplicationScoped
public class TwilioConfiguration {

    @ConfigProperty(name = "twilio.account.sid")
    private String accountSid;

    @ConfigProperty(name = "twilio.auth.token")
    private String authToken;

    @ConfigProperty(name = "twilio.phone.number")
    private String phoneNumber;

    @ConfigProperty(name = "twilio.messaging.service.sid")
    private String messagingServiceSid;

}
