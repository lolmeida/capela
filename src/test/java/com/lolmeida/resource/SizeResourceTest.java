package com.lolmeida.resource;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lolmeida.dto.request.SizeRequest;
import com.lolmeida.dto.response.SizeResponse;
import com.lolmeida.mapper.SizeMapper;
import com.lolmeida.service.SizeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SizeResourceTest {

    @Mock
    private SizeService sizeService;

    @Mock
    private SizeMapper sizeMapper;

    @InjectMocks
    private SizeResource sizeResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<SizeResponse> expectedResponses = Arrays.asList(new SizeResponse(), new SizeResponse());
        when(sizeService.findAll(anyString())).thenReturn(expectedResponses);
        when(sizeMapper.objToResponse(any())).thenReturn(new SizeResponse());

        // Act
        Response response = sizeResource.getAll();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponses, response.getEntity());
        verify(sizeService).findAll("date, id");
        verify(sizeMapper, times(expectedResponses.size())).objToResponse(any());
    }

    @Test
    public void testSearch() {
        // Arrange
        String field = "field";
        String value = "value";
        List<SizeResponse> expectedResponses = Arrays.asList(new SizeResponse(), new SizeResponse());
        when(sizeService.search(eq(field), eq(value))).thenReturn(expectedResponses);
        when(sizeMapper.objToResponse(any())).thenReturn(new SizeResponse());

        // Act
        Response response = sizeResource.search(field, value);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponses, response.getEntity());
        verify(sizeService).search(field, value);
        verify(sizeMapper, times(expectedResponses.size())).objToResponse(any());
    }

    @Test
    public void testFindByCustomer() {
        // Arrange
        String id = "id";
        List<SizeResponse> expectedResponses = Arrays.asList(new SizeResponse(), new SizeResponse());
        when(sizeService.findBy(eq(id))).thenReturn(expectedResponses);
        when(sizeMapper.objToResponse(any())).thenReturn(new SizeResponse());

        // Act
        Response response = sizeResource.findByCustomer(id);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedResponses, response.getEntity());
        verify(sizeService).findBy(id);
        verify(sizeMapper, times(expectedResponses.size())).objToResponse(any());
    }

    @Test
    public void testSave() {
        // Arrange
        SizeRequest request = new SizeRequest();
        when(sizeMapper.requestToObj(any())).thenReturn(new SizeResponse());

        // Act
        Response response = sizeResource.save(request);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        verify(sizeService).save(any());
        verify(sizeMapper).requestToObj(request);
    }
}