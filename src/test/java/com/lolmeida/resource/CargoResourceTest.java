package com.lolmeida.resource;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lolmeida.dto.request.CargoRequest;
import com.lolmeida.dto.response.CargoResponse;
import com.lolmeida.mapper.CargoMapper;
import com.lolmeida.service.CargoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CargoResourceTest {

    @Mock
    private CargoService cargoService;

    @Mock
    private CargoMapper cargoMapper;

    @InjectMocks
    private CargoResource cargoResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        // Arrange
        List<CargoResponse> expectedData = Arrays.asList(new CargoResponse(), new CargoResponse());
        when(cargoService.findAll(anyString())).thenReturn(expectedData);

        // Act
        Response response = cargoResource.getAll();
        List<CargoResponse> actualData = (List<CargoResponse>) response.getEntity();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedData, actualData);
        verify(cargoService).findAll("date, cargoNumber");
    }

    @Test
    public void testSearch() {
        // Arrange
        List<CargoResponse> expectedData = Arrays.asList(new CargoResponse(), new CargoResponse());
        when(cargoService.search(anyString(), anyString())).thenReturn(expectedData);

        // Act
        Response response = cargoResource.search("field", "value");
        List<CargoResponse> actualData = (List<CargoResponse>) response.getEntity();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedData, actualData);
        verify(cargoService).search("field", "value");
    }

    @Test
    public void testFindByCustomer() {
        // Arrange
        List<CargoResponse> expectedData = Arrays.asList(new CargoResponse(), new CargoResponse());
        when(cargoService.findBy(anyString())).thenReturn(expectedData);

        // Act
        Response response = cargoResource.findByCustomer("id");
        List<CargoResponse> actualData = (List<CargoResponse>) response.getEntity();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedData, actualData);
        verify(cargoService).findBy("id");
    }

    @Test
    public void testSave() {
        // Arrange
        CargoRequest request = new CargoRequest();
        when(cargoMapper.requestToObj(any(CargoRequest.class))).thenReturn(new CargoResponse());
        when(cargoService.save(any(CargoResponse.class))).thenReturn("123");

        // Act
        Response response = cargoResource.save(request);
        List<CargoResponse> actualData = (List<CargoResponse>) response.getEntity();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(expectedData, actualData);
        verify(cargoMapper).requestToObj(request);
        verify(cargoService).save(any(CargoResponse.class));
        verify(cargoService).search("id", "123");
    }
}