package br.com.quarkus.service;

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
    Emitter<CustomerRequest> emitter;

    public void create(CustomerRequest request) {
        emitter.send(request);
    }
}
