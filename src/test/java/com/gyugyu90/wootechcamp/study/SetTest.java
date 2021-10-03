package com.gyugyu90.wootechcamp.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @DisplayName("요구사항 1 - set.size()는 실제 크기를 반환함")
    @Test
    void testSize01() {
        assertThat(numbers.size()).isEqualTo(4);
    }

    @DisplayName("요구사항 2 - set.contains() 포함하는 값이 있으면 true를 반환함")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void testContains01(int value) {
        assertTrue(numbers.contains(value));
    }

    @DisplayName("요구사항 3 - set.contains() 포함하는 값이 없으면 false를 반환함")
    @ParameterizedTest
    @CsvSource(value = {
            "1,true",
            "-1,false",
            "4,true",
            "5,false",
            "100,false"
    }, delimiter = ',')
    void testContains02(int value, boolean result) {
        assertThat(numbers.contains(value)).isEqualTo(result);
    }
}
