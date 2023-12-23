package com.lolmeida.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import com.lolmeida.ApplicationPaths;
import com.lolmeida.service.NotificationService;

@Path(ApplicationPaths.API_NOTIFICATION)
@Produces(MediaType.APPLICATION_JSON)
public class NotificationResource {

    @Inject
    NotificationService notification;

    @POST
    @Path(ApplicationPaths.API_SLACK)
    public Response sendSlackMessage(@QueryParam("channel") final String channel, @QueryParam("message") final String message) {
        notification.sendSlackMessage(channel, message);
        return Response.ok(String.format("Message %s was sent to channel %s.", message, channel)).build();
    }

    @POST
    @Path(ApplicationPaths.API_TWILIO)
    public Response sendTwilioMessage(
            @QueryParam("toPhoneNumber") final String toPhoneNumber,
            @QueryParam("message") final String message) {
        return notification.sendTwilioMessage(toPhoneNumber, message);

    }

    @POST
    @Path(ApplicationPaths.API_KAFKA)
    public Response sendFifoMessage(@RequestBody final String message) {
        return notification.sendKafkaMessage(message);

    }

}