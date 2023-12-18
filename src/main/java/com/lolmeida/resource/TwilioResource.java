package com.lolmeida.resource;

import com.lolmeida.service.TwilioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/twilio-sms")
public class TwilioResource {

    @Inject
    TwilioService twilioService;

    @POST
    public void sendMessage(
            @QueryParam("toPhoneNumber") String toPhoneNumber,
            @QueryParam("message") String message) {
        twilioService.sendMessage(toPhoneNumber, message);
    }
}
