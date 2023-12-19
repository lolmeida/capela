package com.lolmeida.resource;

import com.lolmeida.dto.request.SizeRequest;
import com.lolmeida.dto.response.SizeResponse;
import com.lolmeida.mapper.SizeMapper;
import com.lolmeida.service.SizeService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@QuarkusTest
public class SizeResourceTest {

    @Inject
    SizeService service;

    @Inject
    SizeMapper mapper;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new SizeResource(service, mapper));
    }

    @Test
    public void testGetAll() {
        // Mock the service response
        List<SizeResponse> mockData = Arrays.asList(
                new SizeResponse("1", "Size 1"),
                new SizeResponse("2", "Size 2"));
        when(service.findAll("date, id")).thenReturn(mockData);

        // Perform the GET request and validate the response
        given()
                .when().get("/size")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", is(mockData.size()));
    }

    @Test
    public void testSearch() {
        // Mock the service response
        List<SizeResponse> mockData = Arrays.asList(
                new SizeResponse("1", "Size 1"),
                new SizeResponse("2", "Size 2"));
        when(service.search("field", "value")).thenReturn(mockData);

        // Perform the GET request and validate the response
        given()
                .when().get("/size/search/field/value")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", is(mockData.size()));
    }

    @Test
    public void testFindByCustomer() {
        // Mock the service response
        List<SizeResponse> mockData = Arrays.asList(
                new SizeResponse("1", "Size 1"),
                new SizeResponse("2", "Size 2"));
        when(service.findBy("id")).thenReturn(mockData);

        // Perform the GET request and validate the response
        given()
                .when().get("/size/id")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", is(mockData.size()));
    }

    @Test
    public void testSave() {
        // Mock the service response
        SizeRequest request = new SizeRequest("Size 1");
        when(service.save(any())).thenReturn("1");

        // Perform the POST request and validate the response
        given()
                .contentType(ContentType.JSON)
                .body(request, ObjectMapperType.JACKSON_2)
                .when().post("/size")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", is(1));
    }
}