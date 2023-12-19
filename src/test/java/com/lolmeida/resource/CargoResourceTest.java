package com.lolmeida.resource;

import com.lolmeida.dto.request.CargoRequest;
import com.lolmeida.dto.response.CargoResponse;
import com.lolmeida.service.CargoService;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CargoResourceTest {

    @Mock
    private CargoService cargoService;

    @InjectMocks
    private CargoResource cargoResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<CargoResponse> expectedData = new ArrayList<>();
        when(cargoService.findAll("date, cargoNumber")).thenReturn(expectedData);

        // Act
        Response response = cargoResource.getAll();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedData, response.getEntity());
        verify(cargoService, times(1)).findAll("date, cargoNumber");
    }

    @Test
    public void testSearch() {
        // Arrange
        String field = "field";
        String value = "value";
        List<CargoResponse> expectedData = new ArrayList<>();
        when(cargoService.search(field, value)).thenReturn(expectedData);

        // Act
        Response response = cargoResource.search(field, value);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedData, response.getEntity());
        verify(cargoService, times(1)).search(field, value);
    }

    @Test
    public void testFindByCustomer() {
        // Arrange
        String id = "id";
        List<CargoResponse> expectedData = new ArrayList<>();
        when(cargoService.findBy(id)).thenReturn(expectedData);

        // Act
        Response response = cargoResource.findByCustomer(id);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedData, response.getEntity());
        verify(cargoService, times(1)).findBy(id);
    }

    @Test
    public void testSave() {
        // Arrange
        CargoRequest cargoRequest = new CargoRequest();
        when(cargoService.save(any())).thenReturn("savedId");

        // Act
        Response response = cargoResource.save(cargoRequest);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("savedId", response.getEntity());
        verify(cargoService, times(1)).save(any());
        verify(cargoService, times(1)).search("id", "savedId");
    }
}