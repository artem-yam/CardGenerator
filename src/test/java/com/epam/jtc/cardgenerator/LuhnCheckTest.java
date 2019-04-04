package com.epam.jtc.cardgenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class LuhnCheckTest {

    private String numberForCheck;
    private boolean isNumberValid;

    public LuhnCheckTest(String numberForCheck, boolean isNumberValid) {
        this.numberForCheck = numberForCheck;
        this.isNumberValid = isNumberValid;
    }

    @Parameterized.Parameters
    public static Collection getParameters() {
        return Arrays.asList(new Object[][]{{"4999991774792811", true},
                {"4999991774792810", false}, {"5469530011273090", true},
                {"5469530011273091", false}});
    }

    @Test
    public void checkNumber() {
        boolean checkResult = CardNumberCorrectnessTest.luhnCheck(
                numberForCheck);

        if (isNumberValid) {
            assertTrue(checkResult);
        } else {
            assertFalse(checkResult);
        }
    }
}
