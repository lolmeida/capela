package com.lolmeida.resource;

import com.lolmeida.dto.request.ReceiptRequest;
import com.lolmeida.dto.response.ReceiptResponse;
import com.lolmeida.mapper.ReceiptMapper;
import com.lolmeida.service.ReceiptService;
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
public class ReceiptResourceTest {

    @Inject
    ReceiptService service;

    @Inject
    ReceiptMapper mapper;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new ReceiptResource(service, mapper));
    }

    @Test
    public void testGetAll() {
        // Mock the service response
        List<ReceiptResponse> mockData = Arrays.asList(
                new ReceiptResponse("1", "Receipt 1"),
                new ReceiptResponse("2", "Receipt 2"));
        when(service.findAll("date, id")).thenReturn(mockData);

        // Perform the GET request and validate the response
        given()
                .when().get("/receipt")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", is(mockData.size()));
    }

    @Test
    public void testSearch() {
        // Mock the service response
        List<ReceiptResponse> mockData = Arrays.asList(
                new ReceiptResponse("1", "Receipt 1"),
                new ReceiptResponse("2", "Receipt 2"));
        when(service.search("field", "value")).thenReturn(mockData);

        // Perform the GET request and validate the response
        given()
                .when().get("/receipt/search/field/value")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", is(mockData.size()));
    }

    @Test
    public void testFindByCustomer() {
        // Mock the service response
        List<ReceiptResponse> mockData = Arrays.asList(
                new ReceiptResponse("1", "Receipt 1"),
                new ReceiptResponse("2", "Receipt 2"));
        when(service.findBy("id")).thenReturn(mockData);

        // Perform the GET request and validate the response
        given()
                .when().get("/receipt/id")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", is(mockData.size()));
    }

    @Test
    public void testSave() {
        // Mock the service response
        ReceiptRequest request = new ReceiptRequest("Receipt 1");
        when(service.save(any())).thenReturn("1");

        // Perform the POST request and validate the response
        given()
                .contentType(ContentType.JSON)
                .body(request, ObjectMapperType.JACKSON_2)
                .when().post("/receipt")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$.size()", is(1));
    }
}