package com.example.rsocketclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
public class RSocketConfiguration {

    private final String host;

    private final int port;

    public RSocketConfiguration(@Value("${rsocket-server.host}") final String host, @Value("${rsocket-server.port}") final int port) {
        this.host = host;
        this.port = port;
    }

    @Bean
    public RSocketRequester rSocketRequester(RSocketRequester.Builder builder) {
        return builder.connectTcp(host, port).block();
    }

}
