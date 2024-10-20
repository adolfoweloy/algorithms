package com.adolfoeloy.dpstudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoDimensionDPTest {
    private final TwoDimensionDP subject = new TwoDimensionDP();

    @Test
    void test1() {
        int[] nums = new int[]{1,2,3};
        int[] multipliers = new int[]{3,2,1};

        int output = subject.maximumScore(nums, multipliers);

        Assertions.assertThat(output).isEqualTo(14);
    }
}