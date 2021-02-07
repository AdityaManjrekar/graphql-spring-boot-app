package com.graphql.app.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Client {
    private UUID id;
    private String firstName;
    private String lastName;
    private List<String> middleNames;
}
