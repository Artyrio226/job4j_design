package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void when3ThenFizz() {
        List<Integer> list = List.of(3, 6, 9, 12, 27, 39, 72);
        List<String> rsl = new ArrayList<>();
        for (Integer i: list) {
            rsl.add(Fool.ans(i));
        }
        assertThat(rsl).containsExactly("Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz");
    }

    @Test
    void when5ThenBuzz() {
        List<Integer> list = List.of(5, 10, 20, 25, 35, 80, 95);
        List<String> rsl = new ArrayList<>();
        for (Integer i: list) {
            rsl.add(Fool.ans(i));
        }
        assertThat(rsl).containsExactly("Buzz", "Buzz", "Buzz", "Buzz", "Buzz", "Buzz", "Buzz");
    }

    @Test
    void when15ThenFizzBuzz() {
        List<Integer> list = List.of(15, 30, 45, 60, 75, 90);
        List<String> rsl = new ArrayList<>();
        for (Integer i: list) {
            rsl.add(Fool.ans(i));
        }
        assertThat(rsl).containsExactly("FizzBuzz", "FizzBuzz", "FizzBuzz", "FizzBuzz", "FizzBuzz", "FizzBuzz");
    }

    @Test
    void whenNumberThenNumber() {
        List<Integer> list = List.of(4, 13, 22, 34, 46, 77, 94);
        List<String> rsl = new ArrayList<>();
        for (Integer i: list) {
            rsl.add(Fool.ans(i));
        }
        assertThat(rsl).containsExactly("4", "13", "22", "34", "46", "77", "94");
    }
}