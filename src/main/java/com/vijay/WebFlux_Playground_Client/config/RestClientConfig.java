package com.vijay.WebFlux_Playground_Client.config;

import com.vijay.WebFlux_Playground_Client.service.RestClientUserService;
import com.vijay.WebFlux_Playground_Client.service.UserClientRest;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    // for reactive thing RestClient is not work, better
    // you can use with simple Spring boot like webclient declarative way also
    @Bean
    public RestClient restClient(){
        return RestClient.builder()
                .baseUrl("http://localhost:9090")
                .build();
    }
    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl("http://localhost:9090")
                .build();
    }
     // this is declarative way
    @SneakyThrows
    @Bean
    RestClientUserService userService() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory
                        .builderFor(WebClientAdapter.create(webClient()))
                        //.builderFor(RestClientAdapter.create(restClient()))
                        .build();
        return httpServiceProxyFactory.createClient(RestClientUserService.class);
    }
    @SneakyThrows
    @Bean
    UserClientRest userClientRest() {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory
                        .builderFor(RestClientAdapter.create(restClient()))
                        .build();
        return httpServiceProxyFactory.createClient(UserClientRest.class);
    }


}
