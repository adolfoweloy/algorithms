package com.adolfoeloy.dpstudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteAndEarnTest {
    private DeleteAndEarn subject = new DeleteAndEarn();

    @Test
    void test1() {
        int output = subject.deleteAndEarn(new int[] {3,4,2});
        Assertions.assertThat(output).isEqualTo(6);
    }

    @Test
    void test2() {
        int output = subject.deleteAndEarn(new int[] {2,2,3,3,3,4});
        Assertions.assertThat(output).isEqualTo(9);
    }    @Test

    void test3() {
        int output = subject.deleteAndEarn(new int[] {1,1,1,2,4,5,5,5,6});
        Assertions.assertThat(output).isEqualTo(18);
    }

}