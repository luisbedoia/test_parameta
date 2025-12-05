package com.example.helloworld.soap.endpoint;

import java.time.OffsetDateTime;

import org.springframework.util.StringUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.helloworld.soap.model.GreetingRequest;
import com.example.helloworld.soap.model.GreetingResponse;

@Endpoint
public class GreetingEndpoint {

    public static final String NAMESPACE_URI = "http://example.com/helloworld/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GreetingRequest")
    @ResponsePayload
    public GreetingResponse greet(@RequestPayload GreetingRequest request) {
        String normalizedName = request != null && StringUtils.hasText(request.getName())
            ? request.getName()
            : "World";

        GreetingResponse response = new GreetingResponse();
        response.setMessage("Hello " + normalizedName + "!");
        response.setTimestamp(OffsetDateTime.now().toString());
        return response;
    }
}
