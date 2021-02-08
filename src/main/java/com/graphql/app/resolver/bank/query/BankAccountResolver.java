package com.graphql.app.resolver.bank.query;

import com.graphql.app.data.BankAccount;
import com.graphql.app.data.Client;
import com.graphql.app.data.Currency;
import graphql.GraphQLException;
import graphql.GraphqlErrorException;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import javax.naming.spi.Resolver;
import java.util.Arrays;
import java.util.UUID;

@Component
public class BankAccountResolver implements GraphQLQueryResolver {
    public BankAccount bankaccount(UUID id){
        throw new RuntimeException("Client unavailable");
       /* return BankAccount.builder()
                .id(id)
                .currency(Currency.CAD)
                .build();*/
    }
}
