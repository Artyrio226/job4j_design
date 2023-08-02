package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/test1.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("#ok")).isEqualTo(null);
        assertThat(config.value("ok1")).isEqualTo("Russia");
        assertThat(config.value("test")).isEqualTo("valid=");
        assertThat(config.value("key")).isEqualTo("val#13");
    }

    @Test
    void whenPairWithoutKey() {
        String path = "./data/test2.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenPairWithoutValue() {
        String path = "./data/test3.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }
}