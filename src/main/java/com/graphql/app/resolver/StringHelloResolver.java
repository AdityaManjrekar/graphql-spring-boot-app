package com.graphql.app.resolver;

import com.graphql.app.data.StringHello;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class StringHelloResolver implements GraphQLQueryResolver {

    public StringHello getHello(){
        return StringHello.builder().str("Hello Welcome to first Graphql Servcer").build();
    }
}
