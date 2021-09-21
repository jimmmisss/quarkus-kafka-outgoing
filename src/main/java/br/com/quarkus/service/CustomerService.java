package br.com.quarkus.service;

import br.com.quarkus.payload.request.CustomerMessage;
import br.com.quarkus.payload.request.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@RequiredArgsConstructor
public class CustomerService {

    @Inject
    @Channel("customer-out")
    Emitter<CustomerMessage> emitter;

    public void create(CustomerRequest request) {
        CustomerMessage message = CustomerMessage.builder()
                .customerRequest(request)
                .action("bff message")
                .build();
        emitter.send(message);
    }
}
