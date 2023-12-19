package com.lolmeida.resource;

import com.lolmeida.dto.request.ClientRequest;
import com.lolmeida.dto.response.ClientResponse;
import com.lolmeida.mapper.ClientMapper;
import com.lolmeida.service.ClientService;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClientResourceTest {

    @Mock
    private ClientService clientService;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientResource clientResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        List<ClientResponse> expectedResponse = Arrays.asList(new ClientResponse());
        when(clientService.findAll("date, name")).thenReturn(Arrays.asList(new ClientRequest()));
        when(clientMapper.objToResponse(any(ClientRequest.class))).thenReturn(new ClientResponse());

        Response response = clientResource.getAll();
        List<ClientResponse> result = (List<ClientResponse>) response.getEntity();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponse.size(), result.size());
        verify(clientService, times(1)).findAll("date, name");
        verify(clientMapper, times(1)).objToResponse(any(ClientRequest.class));
    }

    @Test
    public void testSearch() {
        List<ClientResponse> expectedResponse = Arrays.asList(new ClientResponse());
        when(clientService.search("field", "value")).thenReturn(Arrays.asList(new ClientRequest()));
        when(clientMapper.objToResponse(any(ClientRequest.class))).thenReturn(new ClientResponse());

        Response response = clientResource.search("field", "value");
        List<ClientResponse> result = (List<ClientResponse>) response.getEntity();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponse.size(), result.size());
        verify(clientService, times(1)).search("field", "value");
        verify(clientMapper, times(1)).objToResponse(any(ClientRequest.class));
    }

    @Test
    public void testFindByCustomer() {
        List<ClientResponse> expectedResponse = Arrays.asList(new ClientResponse());
        when(clientService.findBy("id")).thenReturn(Arrays.asList(new ClientRequest()));
        when(clientMapper.objToResponse(any(ClientRequest.class))).thenReturn(new ClientResponse());

        Response response = clientResource.findByCustomer("id");
        List<ClientResponse> result = (List<ClientResponse>) response.getEntity();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponse.size(), result.size());
        verify(clientService, times(1)).findBy("id");
        verify(clientMapper, times(1)).objToResponse(any(ClientRequest.class));
    }

    @Test
    public void testSave() {
        ClientRequest request = new ClientRequest();
        when(clientMapper.requestToObj(request)).thenReturn(new ClientRequest());
        when(clientService.save(any(ClientRequest.class))).thenReturn("id");
        when(clientService.search("name", "id")).thenReturn(Arrays.asList(new ClientRequest()));

        Response response = clientResource.save(request);
        List<ClientResponse> result = (List<ClientResponse>) response.getEntity();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(1, result.size());
        verify(clientMapper, times(1)).requestToObj(request);
        verify(clientService, times(1)).save(any(ClientRequest.class));
        verify(clientService, times(1)).search("name", "id");
    }
}