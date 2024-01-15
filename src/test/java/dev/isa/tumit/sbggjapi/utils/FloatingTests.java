package dev.isa.tumit.sbggjapi.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class FloatingTests {

    @Test
    void shouldShowIEEE754() {
        // * arrange
        // * act
        String actual = FloatingUtil.toIEEE754(0.5F);
        // * assert
        String expected = "111111000000000000000000000000";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldPrint() {
        // * arrange
        // * act
        // * assert
        var out1 = FloatingUtil.toIEEE754(0.5F);
        System.out.printf("%s : len=%s%n", out1, out1.replace(" ", "").length());
        var out2 = FloatingUtil.toIEEE754(1.5F);
        System.out.printf("%s : len=%s%n", out2, out2.replace(" ", "").length());

        var out3 = FloatingUtil.toIEEE754(1F);
        System.out.printf("%s : len=%s%n", out3, out3.replace(" ", "").length());
    }
}

