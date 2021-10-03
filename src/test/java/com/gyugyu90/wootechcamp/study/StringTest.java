package com.gyugyu90.wootechcamp.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("요구사항 1 - `1,2`를 comma로 split 하면 두 개로 분리되어야 함")
    @Test
    void testStringSplit01() {
        var string = "1,2";
        var split = string.split(",");
        assertThat(split).isEqualTo(new String[]{"1", "2"});
        assertThat(split).containsExactly("1", "2");
    }

    @DisplayName("요구사항 1 - `1,`를 comma로 split 하면 1만 존재해야 함")
    @Test
    void testStringSplit02() {
        var string = "1,";
        var split = string.split(",");
        assertThat(split).isEqualTo(new String[]{"1"});
        assertThat(split).contains("1");
    }

    @DisplayName("요구사항 2 - 괄호 제거")
    @Test
    void testSubstring01() {
        var string = "(1,2)";
        assertThat(stripParentheses(string)).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3 - chatAt은 포함하는 캐릭터의 index 값을 반환해야 함")
    @Test
    void testCharAt01() {
        var string = "abc";
        assertThat(string.charAt(0)).isEqualTo('a');
        assertThat(string.charAt(1)).isEqualTo('b');
        assertThat(string.charAt(2)).isEqualTo('c');
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @DisplayName("요구사항 3 - charAt이 문자열의 index를 벗어나면 예외를 발생함")
    @Test
    void testCharAt02() {
        var string = "abc";
        assertThatThrownBy(() -> string.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    private String stripParentheses(String source) {
        return source.substring(source.indexOf('(') + 1, source.indexOf(')'));
    }
}
