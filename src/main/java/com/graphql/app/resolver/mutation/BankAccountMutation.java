package com.graphql.app.resolver.mutation;

import com.graphql.app.data.BankAccount;
import com.graphql.app.data.Client;
import com.graphql.app.data.CreateBankAccountInput;
import com.graphql.app.data.Currency;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BankAccountMutation implements GraphQLMutationResolver {

    public BankAccount createBankAccount(CreateBankAccountInput createBankAccountInput){
        return BankAccount.builder()
                .id(UUID.randomUUID())
                .client(Client.builder()
                        .firstName(createBankAccountInput.getFirstName())
                        .build())
                .currency(Currency.CAD).build();
    }
}
