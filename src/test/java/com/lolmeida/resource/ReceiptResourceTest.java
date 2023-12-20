package com.lolmeida.resource;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lolmeida.dto.request.ReceiptRequest;
import com.lolmeida.dto.response.ReceiptResponse;
import com.lolmeida.mapper.ReceiptMapper;
import com.lolmeida.service.ReceiptService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReceiptResourceTest {

    @Mock
    private ReceiptService receiptService;

    @Mock
    private ReceiptMapper receiptMapper;

    @InjectMocks
    private ReceiptResource receiptResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<ReceiptResponse> expectedResponses = Arrays.asList(new ReceiptResponse(), new ReceiptResponse());
        when(receiptService.findAll(anyString())).thenReturn(expectedResponses);

        // Act
        Response response = receiptResource.getAll();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponses, response.getEntity());
        verify(receiptService).findAll("date, id");
    }

    @Test
    public void testSearch() {
        // Arrange
        List<ReceiptResponse> expectedResponses = Arrays.asList(new ReceiptResponse(), new ReceiptResponse());
        when(receiptService.search(anyString(), anyString())).thenReturn(expectedResponses);

        // Act
        Response response = receiptResource.search("field", "value");

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponses, response.getEntity());
        verify(receiptService).search("field", "value");
    }

    @Test
    public void testFindByCustomer() {
        // Arrange
        List<ReceiptResponse> expectedResponses = Arrays.asList(new ReceiptResponse(), new ReceiptResponse());
        when(receiptService.findBy(anyString())).thenReturn(expectedResponses);

        // Act
        Response response = receiptResource.findByCustomer("id");

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponses, response.getEntity());
        verify(receiptService).findBy("id");
    }

    @Test
    public void testSave() {
        // Arrange
        ReceiptRequest request = new ReceiptRequest();
        when(receiptMapper.requestToObj(any(ReceiptRequest.class))).thenReturn(new Receipt());

        // Act
        Response response = receiptResource.save(request);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        verify(receiptService).save(any(Receipt.class));
        verify(receiptMapper).requestToObj(request);
    }
}