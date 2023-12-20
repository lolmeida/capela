package com.lolmeida.service;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lolmeida.entity.database.Client;
import com.lolmeida.repository.ClientRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClientServiceTest {

    @Mock
    private ClientRepository repository;

    @Mock
    private NotificationService notification;

    private ClientService clientService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        clientService = new ClientService();
        clientService.repository = repository;
        clientService.notification = notification;
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Client> expectedClients = Arrays.asList(new Client(), new Client());
        when(repository.findAll(any())).thenReturn(expectedClients);

        // Act
        List<Client> actualClients = clientService.findAll("id");

        // Assert
        assertEquals(expectedClients, actualClients);
        verify(repository).findAll("id");
    }

    @Test
    public void testSearch() {
        // Arrange
        List<Client> expectedClients = Arrays.asList(new Client(), new Client());
        when(repository.search(anyString(), anyString())).thenReturn(expectedClients);

        // Act
        List<Client> actualClients = clientService.search("name", "example");

        // Assert
        assertEquals(expectedClients, actualClients);
        verify(repository).search("name", "example");
    }

    @Test
    public void testFindBy() {
        // Arrange
        List<Client> expectedClients = Arrays.asList(new Client(), new Client());
        when(repository.findBy(anyString())).thenReturn(expectedClients);

        // Act
        List<Client> actualClients = clientService.findBy("123");

        // Assert
        assertEquals(expectedClients, actualClients);
        verify(repository).findBy("123");
    }

    @Test
    public void testSave() {
        // Arrange
        Client client = new Client();

        // Act
        String savedId = clientService.save(client);

        // Assert
        assertEquals(savedId, client.getId());
        verify(repository).save(client);
        verify(notification).sendTwilioMessage(client.getPhoneNumber(),
                String.format("Olá %s, Seja bem vindo. Temos muito gosto em ter voçê connosco!", client.getName()));
    }
}