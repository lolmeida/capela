package com.lolmeida.resource;

import com.google.inject.Inject;
import com.lolmeida.dto.request.CargoRequest;
import com.lolmeida.dto.response.CargoResponse;
import com.lolmeida.mapper.CargoMapper;
import com.lolmeida.service.CargoService;
import com.lolmeida.service.NotificationService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.smallrye.common.constraint.Assert.assertFalse;
import static io.smallrye.common.constraint.Assert.assertNotNull;


@QuarkusTest
class CargoResourceTest {

    @Inject
    CargoService service;

    @Inject
    CargoMapper mapper;

    @Inject
    NotificationService notification;


    @Test
    public void testGetAll() {
        // Arrange


        // Act
        List<CargoResponse> data = service.findAll("date, cargoNumber")
                .stream()
                .map(e -> mapper.objToResponse(e))
                .toList();

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertNotNull(data),
                () -> Assertions.assertEquals(0, data.size()));
    }


    @Test
    public void testSearch() {
        // Arrange
        String field = "field";
        String value = "value";

        // Act
        List<CargoResponse> data = service.search("field", "value")
                .stream()
                .map(e -> mapper.objToResponse(e))
                .toList();

        // Assert
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }


    @Test
    public void testFindByCustomer() {
        // Arrange
        String id = "id";

        // Act
        List<CargoResponse> data = service.findBy("id")
                .stream()
                .map(e -> mapper.objToResponse(e))
                .toList();

        // Assert
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }

    @Test
    public void testSave() {
        // Arrange
        CargoRequest request = CargoRequest
                .builder()
                .build();

        // Act
        String cargo = service.save(mapper.requestToObj(request));
        notification.sendTwilioMessage("+351967622771", request.toString());

        // Assert
        assertNotNull(cargo);
    }


}