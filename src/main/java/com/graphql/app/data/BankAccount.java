package com.graphql.app.data;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class BankAccount {
    private UUID id;
    private Client client;
    private Currency currency;
    private List<Assets> assets;
    private LocalDate createdOn;
    private ZonedDateTime createdAt;

}
