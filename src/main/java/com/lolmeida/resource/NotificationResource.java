package com.lolmeida.resource;

import com.lolmeida.service.NotificationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Path("/sms")
public class NotificationResource {

    @Inject
    NotificationService notification;



    @POST
    @Path("/slack")
    public Response sendSlackMessage(@QueryParam("channel") String channel, @QueryParam("message") String message) {
        notification.sendSlackMessage(channel, message);
        return Response.ok().build();
    }

    @POST
    @Path("/twilio")
    public Response sendTwilioMessage(
            @QueryParam("toPhoneNumber") String toPhoneNumber,
            @QueryParam("message") String message) {
        notification.sendTwilioMessage(toPhoneNumber, message);
        return Response.ok().build();
    }

    @POST
    @Path("/kafka")
    public Response sendKafkaMessage(@RequestBody String message) {
        notification.sendKafkaMessage(message);
        return Response.ok().build();
    }
}