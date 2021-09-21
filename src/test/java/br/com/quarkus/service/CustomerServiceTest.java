package br.com.quarkus.service;

import br.com.quarkus.infra.InfrastructureTest;
import br.com.quarkus.model.CustomerMessageTest;
import br.com.quarkus.payload.request.CustomerMessage;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
@QuarkusTestResource(InfrastructureTest.class)
class CustomerServiceTest {

    @Inject
    @Channel("customer-out")
    Emitter<CustomerMessage> emitter;

    @Test
    void create() throws InterruptedException {
        emitter.send(CustomerMessageTest.theCustomer());
        Thread.sleep(1_000);
    }
}
