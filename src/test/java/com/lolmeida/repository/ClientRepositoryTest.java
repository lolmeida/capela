package com.lolmeida.repository;

import com.lolmeida.entity.database.Client;
import io.quarkus.panache.common.Sort;
import io.smallrye.common.constraint.NotNull;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ApplicationScoped
public class ClientRepositoryTest {

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Client> expectedClients = Arrays.asList(new Client(), new Client());
        when(clientRepository.listAll(Sort.descending(anyString()))).thenReturn(expectedClients);

        // Act
        List<Client> actualClients = clientRepository.findAll("id");

        // Assert
        assertEquals(expectedClients, actualClients);
        verify(clientRepository).listAll(Sort.descending("id"));
    }

    @Test
    public void testSearch() {
        // Arrange
        List<Client> expectedClients = Arrays.asList(new Client(), new Client());
        when(clientRepository.list(anyString(), anyString())).thenReturn(expectedClients);

        // Act
        List<Client> actualClients = clientRepository.search("name", "example");

        // Assert
        assertEquals(expectedClients, actualClients);
        verify(clientRepository).list("LOWER(name) like ?1", "%example%");
    }

    @Test
    public void testFindBy() {
        // Arrange
        List<Client> expectedClients = Arrays.asList(new Client(), new Client());
        when(clientRepository.list(anyString(), anyString())).thenReturn(expectedClients);

        // Act
        List<Client> actualClients = clientRepository.findBy("123");

        // Assert
        assertEquals(expectedClients, actualClients);
        verify(clientRepository).list("Client like ?1", "123");
    }

    @Test
    @Transactional
    public void testSave() {
        // Arrange
        Client client = new Client();
        client.setId(UUID.randomUUID().toString());

        // Act
        String savedId = clientRepository.save(client);

        // Assert
        assertEquals(client.getId(), savedId);
        verify(clientRepository).persistAndFlush(client);
    }
}