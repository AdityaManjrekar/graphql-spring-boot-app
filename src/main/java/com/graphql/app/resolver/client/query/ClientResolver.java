package com.graphql.app.resolver.client.query;

import com.graphql.app.data.BankAccount;
import com.graphql.app.data.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    private final ExecutorService executorService =  Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

     public CompletableFuture<DataFetcherResult<Client>> client(BankAccount bankAccount){

         return CompletableFuture.supplyAsync(
                 () -> {
                     return DataFetcherResult.<Client>newResult()
                             .data(Client.builder()
                                     .id(bankAccount.getId())
                                     .firstName(bankAccount.getClient().getFirstName())
                                     .middleNames(bankAccount.getClient().getMiddleNames())
                                     .lastName(bankAccount.getClient().getLastName())
                                     .build())
                             .error(new GenericGraphQLError("Could not get client infomration"))
                             .build();
                 },executorService
         );


     }
}
