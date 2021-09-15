package br.com.quarkus.controller;

import br.com.quarkus.controller.openapi.CustomerOpenApi;
import br.com.quarkus.payload.request.CustomerRequest;
import br.com.quarkus.service.CustomerService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;

@Path("/v1/cliente")
@Tag(name = "Cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController implements CustomerOpenApi {

    @Inject
    CustomerService service;

    @POST
    public Response create(@Valid CustomerRequest request) {
        service.create(request);
        return Response.status(CREATED).build();
    }
}