package com.epam.jtc.concurrentPlane;

import com.epam.cardgenerator.CardGenerator;
import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.cardmodel.CardTypesEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class CardNumberCorrectnessTest {

    private Card testedCard;

    public CardNumberCorrectnessTest(String cardType)
            throws IllegalAccessException, InstantiationException {

        testedCard = new CardGenerator().generateCard(cardType);
    }

    @Parameterized.Parameters
    public static Collection getParameters() {
        List<String[]> parameters = new ArrayList<>();

        for (CardTypesEnum value : CardTypesEnum.values()) {
            parameters.add(new String[]{value.toString()});
        }

        return parameters;
    }

    public static boolean luhnCheck(String cardNumber) {

        String reverseNumber = new StringBuffer(cardNumber).reverse()
                                                           .toString();

        int oddPositionNumbersSum = 0;
        int evenPositionNumbersSum = 0;

        for (int i = 0; i < reverseNumber.length(); i++) {
            int digit = Character.digit(reverseNumber.charAt(i), 10);

            if ((i % 2) == 0) {
                evenPositionNumbersSum += digit;
            } else {
                oddPositionNumbersSum += 2 * digit;

                if (digit >= 5) {
                    oddPositionNumbersSum -= 9;
                }
            }
        }

        return (evenPositionNumbersSum + oddPositionNumbersSum) % 10 == 0;
    }

    @Test
    public void checkCardNumberWithLuhnAlgorithm() {
        assertTrue(luhnCheck(testedCard.getNumber()));
    }

    @Test
    public void checkCardNumberConformityToPaymentSystem() {
        int numberLength = testedCard.getNumberLength();
        String bankId = testedCard.getBankID();
        String cardNumber = testedCard.getNumber();

        assertEquals(numberLength, cardNumber.length());
        assertEquals(bankId, cardNumber.substring(0, bankId.length()));
    }
}
