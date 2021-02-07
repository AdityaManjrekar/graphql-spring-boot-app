package com.graphql.app.resolver;

import com.graphql.app.data.BankAccount;
import com.graphql.app.data.Client;
import com.graphql.app.data.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import javax.naming.spi.Resolver;
import java.util.Arrays;
import java.util.UUID;

@Component
public class BankAccountResolver implements GraphQLQueryResolver {
    public BankAccount bankaccount(UUID id){
        return BankAccount.builder()
                .id(id)
                .currency(Currency.CAD)
                .client(Client.builder()
                        .id(id)
                        .firstName("Aditya")
                        .middleNames(Arrays.asList("Manjrekar","Rane"))
                        .lastName("Manjrekar")
                        .build())
                .build();
    }
}
