package ru.job4j.template;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class SimpleGeneratorTest {

    @Test
    void checkNumberKeys() {
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        String str = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of();
        assertThatThrownBy(() -> simpleGenerator.produce(str, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The number of keys does not match.");
    }

    @Test
    void checkMatchingKeys() {
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        String str = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of("name", "Peter Arsentev", "car", "Lada");
        assertThatThrownBy(() -> simpleGenerator.produce(str, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Keys don't match.");
    }
}