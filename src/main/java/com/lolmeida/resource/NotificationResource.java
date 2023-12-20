package com.lolmeida.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import com.lolmeida.service.NotificationService;

@Path("/sms")
@Produces(MediaType.APPLICATION_JSON)
public class NotificationResource {

    @Inject
    NotificationService notification;

    @POST
    @Path("/slack")
    public Response sendSlackMessage(@QueryParam("channel") String channel, @QueryParam("message") String message) {
        notification.sendSlackMessage(channel, message);
        return Response.ok(String.format("Message %s was sent to channel %s.",message, channel)).build();
    }

    @POST
    @Path("/twilio")
    public Response sendTwilioMessage(
            @QueryParam("toPhoneNumber") String toPhoneNumber,
            @QueryParam("message") String message) {
        return notification.sendTwilioMessage(toPhoneNumber, message);

    }

    @POST
    @Path("/kafka")
    public Response sendFifoMessage(@RequestBody String message) {
        return notification.sendKafkaMessage(message);

    }

}