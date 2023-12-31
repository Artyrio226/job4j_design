package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 0, 4);
        ListUtils.addAfter(input, 0, 7);
        ListUtils.removeIf(input, a -> a > 2);
        assertThat(input).hasSize(2).containsSequence(1, 2);
    }

    @Test
    void whenReplaceIf() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 0, 4);
        ListUtils.addAfter(input, 0, 3);
        ListUtils.replaceIf(input, a -> a > 2, 9);
        assertThat(input).hasSize(5).containsSequence(1, 9, 9, 2, 9);
    }

    @Test
    void whenRemoveAll() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.addAfter(input, 0, 4);
        ListUtils.addAfter(input, 0, 7);
        List<Integer> elem = new ArrayList<>(Arrays.asList(4, 1, 3, 5));
        ListUtils.removeAll(input, elem);
        assertThat(input).hasSize(2).containsSequence(7, 2);
    }
}