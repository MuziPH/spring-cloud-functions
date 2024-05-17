package io.glitchtech.cloudfunctions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FunctionsTest {
    Functions functions = new Functions();

    @Test
    void testUppercase() {
        String input = "Spring Cloud";
        String expectedOutput = "SPRING CLOUD";

        String actualOutput = functions.uppercase().apply(input);

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    void testReverse() {
        String input = "Spring Cloud";
        String expectedOutput = "duolC gnirpS";

        String actualOutput = functions.reverse().apply(input);

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    void testUpperCaseThenReverse() {
        String input = "Spring Cloud";
        String expectedOutput = "DUOLC GNIRPS";

        String actualOutput = functions.uppercase().andThen(functions.reverse()).apply(input);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}
