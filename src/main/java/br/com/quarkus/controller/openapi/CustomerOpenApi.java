package br.com.quarkus.controller.openapi;

import br.com.quarkus.payload.request.CustomerRequest;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface CustomerOpenApi {

    @Operation(summary = "Create object")
    @APIResponse(responseCode = "201", content = @Content(mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = CustomerRequest.class, type = SchemaType.OBJECT)))
    Response create(@Valid CustomerRequest request);

}
