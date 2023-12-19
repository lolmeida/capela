package com.lolmeida.resource;

import com.lolmeida.dto.request.ClientRequest;
import com.lolmeida.dto.response.ClientResponse;
import com.lolmeida.mapper.ClientMapper;
import com.lolmeida.service.ClientService;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ClientResourceTest {

    @Mock
    private ClientService clientService;

    @Mock
    private ClientMapper clientMapper;

    private ClientResource clientResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        clientResource = new ClientResource(clientService, clientMapper);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<ClientResponse> expectedClients = Arrays.asList(new ClientResponse(), new ClientResponse());
        when(clientService.findAll(anyString())).thenReturn(expectedClients);

        // Act
        Response response = clientResource.getAll();
        List<ClientResponse> actualClients = (List<ClientResponse>) response.getEntity();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedClients, actualClients);
        verify(clientService).findAll("date, name");
    }

    @Test
    public void testSearch() {
        // Arrange
        List<ClientResponse> expectedClients = Arrays.asList(new ClientResponse(), new ClientResponse());
        when(clientService.search(anyString(), anyString())).thenReturn(expectedClients);

        // Act
        Response response = clientResource.search("field", "value");
        List<ClientResponse> actualClients = (List<ClientResponse>) response.getEntity();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedClients, actualClients);
        verify(clientService).search("field", "value");
    }

    @Test
    public void testFindByCustomer() {
        // Arrange
        List<ClientResponse> expectedClients = Arrays.asList(new ClientResponse(), new ClientResponse());
        when(clientService.findBy(anyString())).thenReturn(expectedClients);

        // Act
        Response response = clientResource.findByCustomer("id");
        List<ClientResponse> actualClients = (List<ClientResponse>) response.getEntity();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedClients, actualClients);
        verify(clientService).findBy("id");
    }

    @Test
    public void testSave() {
        // Arrange
        ClientRequest clientRequest = new ClientRequest();
        when(clientMapper.requestToObj(any(ClientRequest.class))).thenReturn(new Client());

        // Act
        Response response = clientResource.save(clientRequest);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        verify(clientService).save(any(Client.class));
        verify(clientMapper).requestToObj(clientRequest);
    }
}