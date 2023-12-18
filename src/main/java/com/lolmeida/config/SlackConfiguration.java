package com.lolmeida.config;


import jakarta.enterprise.context.ApplicationScoped;
import lombok.Data;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Data
@ApplicationScoped
public class SlackConfiguration {

    @ConfigProperty(name = "slack.app.id")
    private String appID;

    @ConfigProperty(name = "slack.client.id")
    private String clientID;

    @ConfigProperty(name = "slack.client.secret")
    private String clientSecret;

    @ConfigProperty(name="slack.signing.secret")
    private String signingSecret;

    @ConfigProperty(name="slack.verification.token")
    private String VerificationToken;

    @ConfigProperty(name = "slack.sms.token")
    private String smsToken;

}
