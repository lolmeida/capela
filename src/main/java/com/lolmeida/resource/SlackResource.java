package com.lolmeida.resource;

import com.lolmeida.service.SlackService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/slack-sms")
public class SlackResource {

    @Inject
    SlackService slackService;

    @POST
    public void sendMessage(@QueryParam("channel") String channel, @QueryParam("message") String message) {
        slackService.sendMessage(channel, message);
    }
}