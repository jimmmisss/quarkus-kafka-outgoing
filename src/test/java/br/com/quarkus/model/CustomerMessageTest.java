package br.com.quarkus.model;

import br.com.quarkus.payload.request.CustomerMessage;
import br.com.quarkus.payload.request.CustomerRequest;

public class CustomerMessageTest {

    public static CustomerMessage theCustomer() {
        var request = CustomerRequest.builder()
                .name("Wesley")
                .lastname("Pereira")
                .document("1234")
                .build();

        return CustomerMessage.builder()
                .customerRequest(request)
                .action("message bff")
                .build();
    }
}
