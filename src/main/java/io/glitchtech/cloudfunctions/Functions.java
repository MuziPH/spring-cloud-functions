package io.glitchtech.cloudfunctions;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Slf4j
@Configuration
public class Functions {

    @Bean
    Function<String, String> uppercase() {
        return message -> {
            log.info("Converting {} to uppercase", message);
            return message.toUpperCase();
        };
    }

    @Bean
    Function<String, String> reverse() {
        return message -> {
            log.info("Reversing {}", message);
            return new StringBuilder(message).reverse().toString();
        };
    }

    @Bean
    Function<Message, String> reverseWithMessage() {
        return message -> {
            log.info("Reversing Message {}", message.getContent());
            return new StringBuilder(message.getContent()).reverse().toString();
        };
    }

    @Bean
    Function<Flux<String>, Flux<String>> reverseReactive() {
        return messageFlux -> messageFlux
                .map(message -> {
                            log.info("Reversing Reactive {}", message);
                            return new StringBuilder(message).reverse().toString();
                        }
                );

    }
}

@Data
class Message {
    private String content;
}