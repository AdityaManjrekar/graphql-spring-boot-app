package com.graphql.app.resolver.client.query;

import com.graphql.app.data.BankAccount;
import com.graphql.app.data.Client;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

     public Client client(BankAccount bankAccount){
        return Client.builder()
                .id(bankAccount.getId())
                .firstName("Aditya")
                .middleNames(Arrays.asList("Manjrekar","Rane"))
                .lastName("Manjrekar")
                .build();
     }
}
