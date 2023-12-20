package com.lolmeida.resource;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lolmeida.dto.request.RecipientRequest;
import com.lolmeida.dto.response.RecipientResponse;
import com.lolmeida.mapper.RecipientMapper;
import com.lolmeida.service.RecipientService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipientResourceTest {

    @Mock
    private RecipientService recipientService;

    @Mock
    private RecipientMapper recipientMapper;

    private RecipientResource recipientResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        recipientResource = new RecipientResource(recipientService, recipientMapper);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<RecipientResponse> expectedData = Arrays.asList(new RecipientResponse(), new RecipientResponse());
        when(recipientService.findAll("date, id")).thenReturn(expectedData);

        // Act
        Response response = recipientResource.getAll();
        List<RecipientResponse> actualData = (List<RecipientResponse>) response.getEntity();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedData, actualData);
        verify(recipientService).findAll("date, id");
        verify(recipientMapper, times(expectedData.size())).objToResponse(any());
    }

    @Test
    public void testSearch() {
        // Arrange
        String field = "field";
        String value = "value";
        List<RecipientResponse> expectedData = Arrays.asList(new RecipientResponse(), new RecipientResponse());
        when(recipientService.search(field, value)).thenReturn(expectedData);

        // Act
        Response response = recipientResource.search(field, value);
        List<RecipientResponse> actualData = (List<RecipientResponse>) response.getEntity();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedData, actualData);
        verify(recipientService).search(field, value);
        verify(recipientMapper, times(expectedData.size())).objToResponse(any());
    }

    @Test
    public void testFindByCustomer() {
        // Arrange
        String id = "id";
        List<RecipientResponse> expectedData = Arrays.asList(new RecipientResponse(), new RecipientResponse());
        when(recipientService.findBy(id)).thenReturn(expectedData);

        // Act
        Response response = recipientResource.findByCustomer(id);
        List<RecipientResponse> actualData = (List<RecipientResponse>) response.getEntity();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedData, actualData);
        verify(recipientService).findBy(id);
        verify(recipientMapper, times(expectedData.size())).objToResponse(any());
    }

    @Test
    public void testSave() {
        // Arrange
        RecipientRequest request = new RecipientRequest();
        when(recipientMapper.requestToObj(request)).thenReturn(new Recipient());
        when(recipientService.save(any(Recipient.class))).thenReturn("savedId");

        // Act
        Response response = recipientResource.save(request);
        List<RecipientResponse> actualData = (List<RecipientResponse>) response.getEntity();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("savedId", actualData.get(0).getId());
        verify(recipientMapper).requestToObj(request);
        verify(recipientService).save(any(Recipient.class));
        verify(recipientService).search("id", "savedId");
        verify(recipientMapper).objToResponse(any());
    }
}