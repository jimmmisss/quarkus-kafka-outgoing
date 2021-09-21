package br.com.quarkus.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerMessage {

    private CustomerRequest customerRequest;
    private String action;
}
