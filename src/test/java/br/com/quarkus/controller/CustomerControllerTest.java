package br.com.quarkus.controller;

import br.com.quarkus.payload.request.CustomerRequest;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class CustomerControllerTest {

    @Test
    void create() {
        var request = CustomerRequest.builder()
                .name("Wesley")
                .lastname("Pereira")
                .document("1234")
                .build();

        given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/v1/customers")
                .then()
                .statusCode(201);
    }
}