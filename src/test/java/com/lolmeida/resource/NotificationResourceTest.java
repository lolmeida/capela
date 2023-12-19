package com.lolmeida.resource;

import com.lolmeida.service.NotificationService;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NotificationResourceTest {

    @Mock
    private NotificationService notificationService;

    private NotificationResource notificationResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        notificationResource = new NotificationResource(notificationService);
    }

    @Test
    public void testSendSlackMessage() {
        // Arrange
        String channel = "test-channel";
        String message = "test-message";
        Response expectedResponse = Response.ok("Message " + message + " was sent to channel " + channel + ".").build();
        when(notificationService.sendSlackMessage(channel, message)).thenReturn(expectedResponse);

        // Act
        Response actualResponse = notificationResource.sendSlackMessage(channel, message);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(notificationService).sendSlackMessage(channel, message);
    }

    @Test
    public void testSendTwilioMessage() {
        // Arrange
        String toPhoneNumber = "test-phone-number";
        String message = "test-message";
        Response expectedResponse = Response.ok().build();
        when(notificationService.sendTwilioMessage(toPhoneNumber, message)).thenReturn(expectedResponse);

        // Act
        Response actualResponse = notificationResource.sendTwilioMessage(toPhoneNumber, message);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(notificationService).sendTwilioMessage(toPhoneNumber, message);
    }

    @Test
    public void testSendFifoMessage() {
        // Arrange
        String message = "test-message";
        Response expectedResponse = Response.ok().build();
        when(notificationService.sendKafkaMessage(message)).thenReturn(expectedResponse);

        // Act
        Response actualResponse = notificationResource.sendFifoMessage(message);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(notificationService).sendKafkaMessage(message);
    }
}