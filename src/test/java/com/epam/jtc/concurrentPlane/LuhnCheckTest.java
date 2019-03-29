package com.epam.jtc.concurrentPlane;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class LuhnCheckTest {

    private String correctNumberForCheck;
    private String wrongNumberForCheck;

    public LuhnCheckTest(String correctNumber, String wrongNumber) {
        correctNumberForCheck = correctNumber;
        wrongNumberForCheck = wrongNumber;
    }

    @Parameterized.Parameters
    public static Collection getParameters() {
        return Arrays.asList(
                new String[][]{{"4999991774792811", "4999991774792810"},
                        {"2444443033724693", "2444443033724692"},
                        {"5469530011273090", "5469530011273091"}});
    }

    @Test
    public void checkCorrectNumber() {
        assertTrue(CardNumberCorrectnessTest.luhnCheck(correctNumberForCheck));
    }

    @Test
    public void checkWrongNumber() {
        assertFalse(CardNumberCorrectnessTest.luhnCheck(wrongNumberForCheck));
    }
}
