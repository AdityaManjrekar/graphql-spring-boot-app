package com.graphql.app.resolver.mutation;

import com.graphql.app.data.BankAccount;
import com.graphql.app.data.Client;
import com.graphql.app.data.CreateBankAccountInput;
import com.graphql.app.data.Currency;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Validated
public class BankAccountMutation implements GraphQLMutationResolver {

    private final Clock clock;


    public BankAccount createBankAccount(@Valid CreateBankAccountInput createBankAccountInput){
        return BankAccount.builder()
                .id(UUID.randomUUID())
                .client(Client.builder()
                        .firstName(createBankAccountInput.getFirstName())
                        .build())
                .currency(Currency.CAD)
                .createdOn(LocalDate.now(clock))
                .createdAt(ZonedDateTime.now(clock)).build();

    }
}
