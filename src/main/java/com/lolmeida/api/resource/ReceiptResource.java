package com.lolmeida.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.dto.request.ReceiptRequest;
import com.lolmeida.api.dto.response.ReceiptResponse;
import com.lolmeida.api.entity.database.Receipt;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.ReceiptService;

@Path(Values.Paths.RECEIPT)
public class ReceiptResource implements ResourceApi<ReceiptRequest> {

    @Inject
    ReceiptService service;

    public Response getAll() {
        List<ReceiptResponse> data = service.findAll("date, cargo")
                                            .stream()
                                            .map(this::objToResponse)
                                            .toList();
        return Response.ok(data).build();
    }

    public Response search(
            @PathParam("field")
            final String field,
            @PathParam("value")
            final String value) {
        List<ReceiptResponse> data = service.search(field, value)
                                            .stream()
                                            .map(this::objToResponse)
                                            .toList();
        return Response.ok(data).build();
    }

    public Response findByCustomer(
            @PathParam("id")
            final String id) {
        List<ReceiptResponse> data = service.search("id", id)
                                            .stream()
                                            .map(this::objToResponse)
                                            .toList();
        return Response.ok(data).build();
    }

    public Response save(
            @RequestBody ReceiptRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Receipt requestToObj(ReceiptRequest request) {
        return Receipt.builder()
                      //.id(Utils.generateRandomString())
                      .cargo(request.cargo())
                      .amount(request.amount())
                      .otherAmount(request.otherAmount())
                      .client(request.client())

                      .build();
    }

    private ReceiptResponse objToResponse(Receipt entity) {
        return ReceiptResponse.builder()
                              .cargo(entity.getCargo())
                              .amount(entity.getAmount())
                              .otherAmount(entity.getOtherAmount())
                              .client(entity.getClient())

                              // BaseEntity
                              /*.active(entity.isActive())
                              .note(entity.getNote())
                              .description(entity.getDescription())
                              .attachment(entity.getAttachment())
                              .image(entity.getImage())
                              .createdBy(entity.getCreatedBy())
                              .createdAt(entity.getCreatedAt())
                              .createdTime(entity.getCreatedTime())
                              .updatedBy(entity.getUpdatedBy())
                              .updatedTime(entity.getUpdatedTime())
                              .updatedAt(entity.getUpdatedAt())
                              .date(entity.getDate())*/

                              .build();
    }
}
