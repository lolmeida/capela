package com.lolmeida.service;

import com.lolmeida.config.SlackConfiguration;
import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.io.IOException;

@ApplicationScoped
public class SlackService {

    @Inject
    SlackConfiguration slackConfiguration;

    public void sendMessage(String channel, String messageText) {
        try {
            Slack.getInstance().methods(slackConfiguration.getSmsToken()).chatPostMessage(req -> req
                    .channel(channel)
                    .text(messageText));
        } catch (IOException | SlackApiException e) {
            throw new RuntimeException(e);
        }
    }
}

