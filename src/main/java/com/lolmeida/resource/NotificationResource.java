package com.lolmeida.resource;

import com.lolmeida.service.NotificationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/sms")
public class NotificationResource {

    @Inject
    NotificationService notification;

    @POST
    @Path("/slack")
    public void sendSlackMessage(@QueryParam("channel") String channel, @QueryParam("message") String message) {
        notification.sendSlackMessage(channel, message);
    }

    @POST
    @Path("/twilio")
    public void sendTwilioMessage(
            @QueryParam("toPhoneNumber") String toPhoneNumber,
            @QueryParam("message") String message) {
        notification.sendTwilioMessage(toPhoneNumber, message);
    }
}