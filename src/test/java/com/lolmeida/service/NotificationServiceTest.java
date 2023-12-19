package com.lolmeida.service;

import com.lolmeida.config.SlackConfiguration;
import com.lolmeida.config.TwilioConfiguration;
import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Mock
    private TwilioConfiguration twilioConfiguration;

    @Mock
    private SlackConfiguration slackConfiguration;

    @Mock
    private Slack slack;

    @Mock
    private Message.Creator creator;

    @Mock
    private Emitter<String> emitter;

    private NotificationService notificationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        notificationService = new NotificationService();
        notificationService.twilioConfiguration = twilioConfiguration;
        notificationService.slackConfiguration = slackConfiguration;
        notificationService.emitter = emitter;
    }

    @Test
    public void testSendTwilioMessage() {
        // Arrange
        String toPhoneNumber = "test-phone-number";
        String message = "test-message";
        String accountSid = "test-account-sid";
        String authToken = "test-auth-token";
        String phoneNumber = "test-phone-number";
        Twilio.init(accountSid, authToken);
        when(twilioConfiguration.getAccountSid()).thenReturn(accountSid);
        when(twilioConfiguration.getAuthToken()).thenReturn(authToken);
        when(twilioConfiguration.getPhoneNumber()).thenReturn(phoneNumber);
        when(Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(phoneNumber), message))
                .thenReturn(creator);
        when(creator.create()).thenReturn(null);
        Response expectedResponse = Response.ok(String.format("Message %s sent to %s", message, toPhoneNumber)).build();

        // Act
        Response actualResponse = notificationService.sendTwilioMessage(toPhoneNumber, message);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(twilioConfiguration).getAccountSid();
        verify(twilioConfiguration).getAuthToken();
        verify(twilioConfiguration).getPhoneNumber();
        verify(Message).creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(phoneNumber), message);
        verify(creator).create();
    }

    @Test
    public void testSendSlackMessage() throws IOException, SlackApiException {
        // Arrange
        String channel = "test-channel";
        String messageText = "test-message";
        String smsToken = "test-sms-token";
        when(slackConfiguration.getSmsToken()).thenReturn(smsToken);
        doNothing().when(slack).methods(smsToken);
        Response expectedResponse = Response.ok().build();

        // Act
        notificationService.sendSlackMessage(channel, messageText);

        // Assert
        verify(slackConfiguration).getSmsToken();
        verify(slack).methods(smsToken);
    }

    @Test
    public void testSendKafkaMessage() {
        // Arrange
        String message = "test-message";
        Response expectedResponse = Response.ok(String.format("Message %s sent.", message)).build();

        // Act
        Response actualResponse = notificationService.sendKafkaMessage(message);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(emitter).send(message);
    }
}