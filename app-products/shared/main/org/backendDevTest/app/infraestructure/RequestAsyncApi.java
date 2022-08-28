package org.backendDevTest.app.infraestructure;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


public class RequestAsyncApi {

    private static Environment environment;
    private static final String URL = environment.getProperty("url.store.products");
    public RequestAsyncApi(Environment environment){
        this.environment = environment;
    }


    public static WebClient asyncRequest(String params){
        WebClient webClient = WebClient.builder()
                .baseUrl(URL + params)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return webClient;
    }

}
