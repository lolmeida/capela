package com.lolmeida.config;

import com.lolmeida.service.NotificationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaConsumer {

    @Inject
    NotificationService service;

    @Incoming("sms-notifications")
    public void onSmsNotification(String message) {
        service.sendTwilioMessage("+351967622771",
                message);

    }
}

