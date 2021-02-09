package com.graphql.app.rest.client;

import com.graphql.app.data.ResponseStringHello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class RestController {

    @GetMapping("/getHello")
    public String getgetHello(){
        RestTemplate restTemplate = new RestTemplate();
        String query = "{\"query\" : \"query { getHello {str} }\"}";
        ResponseStringHello stringHello = restTemplate.postForEntity("http://localhost:8080/graphql",query, ResponseStringHello.class).getBody();
        return stringHello.getData().getGetHello().getStr();
    }
}
