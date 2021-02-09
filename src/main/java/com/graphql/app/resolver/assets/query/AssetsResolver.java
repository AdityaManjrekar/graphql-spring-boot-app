package com.graphql.app.resolver.assets.query;

import com.graphql.app.data.Assets;
import com.graphql.app.data.BankAccount;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class AssetsResolver implements GraphQLResolver<BankAccount> {

    private final ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );


    public CompletableFuture<DataFetcherResult<List<Assets>>> assets(BankAccount bankAccount){
        return CompletableFuture.supplyAsync(
                () -> {
                    return DataFetcherResult.<List<Assets>>newResult()
                            .data(Arrays.asList(
                                    Assets.builder()
                                            .name("New York")
                                            .build(),
                                    Assets.builder()
                                            .name("Chicago")
                                            .build()
                            ))
                            .error(new GenericGraphQLError("Could not get Aseests infomration"))
                            .build();
                },
                executorService
        );


    }
}
