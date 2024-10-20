package com.adolfoeloy.dpstudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteAndEarnTest {
    private DeleteAndEarn subject = new DeleteAndEarn();

    @Test
    void test1() {
        int output = subject.solve(new int[] {3,4,2});
        Assertions.assertThat(output).isEqualTo(6);
    }

    @Test
    void test1() {
        int output = subject.solve(new int[] {2,2,3,3,3,4});
        Assertions.assertThat(output).isEqualTo(9);
    }

}