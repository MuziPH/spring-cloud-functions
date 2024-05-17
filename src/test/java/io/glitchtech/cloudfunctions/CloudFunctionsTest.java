package io.glitchtech.cloudfunctions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.function.Function;

@FunctionalSpringBootTest
public class CloudFunctionsTest {
    @Autowired
    private FunctionCatalog catalog;

    @Test
    void testUppercaseThenReverseReactive() {
        String input = "Spring Cloud";
        String expectedOutput = "DUOLC GNIRPS";

        // Combining a reactive and imperative = reactive function
        Function<Flux<String>, Flux<String>> upperThenReverse = catalog
                .lookup(Function.class, "uppercase|reverseReactive");

        StepVerifier.create(upperThenReverse.apply(Flux.just(input)))
                .expectNextMatches(actualOutput -> actualOutput.equals(expectedOutput))
                .verifyComplete();
    }
}
