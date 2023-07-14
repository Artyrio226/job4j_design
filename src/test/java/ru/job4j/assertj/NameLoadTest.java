package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void nameIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        String[] names = new String[0];
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is empty");
    }

    @Test
    void whenMissingSymbol() {
        NameLoad nameLoad = new NameLoad();
        String name = "Smith-driver";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: %s does not contain the symbol '='".formatted(name))
                .hasMessageContaining("Smith-driver");
    }

    @Test
    void whenNotContainKey() {
        NameLoad nameLoad = new NameLoad();
        String name = "=driver";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: %s does not contain a key".formatted(name))
                .hasMessageContaining("=driver");
    }

    @Test
    void whenNotContainValue() {
        NameLoad nameLoad = new NameLoad();
        String name = "Smith=";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: %s does not contain a value".formatted(name))
                .hasMessageContaining("Smith=");
    }
}