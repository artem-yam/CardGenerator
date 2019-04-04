package com.epam.jtc.cardgenerator;

import com.epam.cardgenerator.CardGenerator;
import com.epam.cardgenerator.cardmodel.Card;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class CardNumberCorrectnessTest {

    private static List<String> MASTERCARD = new ArrayList<>();
    private static List<String> MIR = new ArrayList<>();
    private static List<String> VISA = new ArrayList<>();
    private static int numberLength = 16;

    private Card testedCard;
    private CardTypeForTest cardType;

    public CardNumberCorrectnessTest(CardTypeForTest cardType)
            throws IllegalAccessException, InstantiationException {

        this.cardType = cardType;
        testedCard = new CardGenerator().generateCard(cardType.toString());
    }

    @Parameterized.Parameters
    public static Collection getParameters() {
        List<Object[]> parameters = new ArrayList<>();

        for (CardTypeForTest value : CardTypeForTest.values()) {
            parameters.add(new Object[]{value});
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

    @Before
    public void initializeStaticVars() {
        VISA.add("4");
        for (int i = 2200; i <= 2204; i++) {
            MIR.add(String.valueOf(i));
        }
        for (int i = 51; i <= 55; i++) {
            MASTERCARD.add(String.valueOf(i));
        }
        for (int i = 2221; i <= 2720; i++) {
            MASTERCARD.add(String.valueOf(i));
        }
    }

    @Test
    public void checkCardNumberWithLuhnAlgorithm() {
        assertTrue(luhnCheck(testedCard.getNumber()));
    }

    @Test
    public void checkCardNumberConformityToPaymentSystem() {
        List<String> validBankIDs = null;

        if (cardType.equals(CardTypeForTest.VISA_CLASSIC) || cardType.equals(
                CardTypeForTest.VISA_ELECTRON) || cardType.equals(
                CardTypeForTest.VISA_GOLD)) {
            validBankIDs = VISA;
        } else if (cardType.equals(CardTypeForTest.MASTERCARD_STANDARD) ||
                cardType.equals(CardTypeForTest.MASTERCARD_ELECTRONIC) ||
                cardType.equals(CardTypeForTest.MASTERCARD_MAESTRO)) {
            validBankIDs = MASTERCARD;
        } else if (cardType.equals(CardTypeForTest.MIR_CLASSIC) ||
                cardType.equals(CardTypeForTest.MIR_PREMIAL) || cardType.equals(
                CardTypeForTest.MIR_DEBIT)) {
            validBankIDs = MIR;
        } else {
            fail();
        }

        assertEquals(numberLength, testedCard.getNumber().length());

        boolean isBankIDValid = false;

        for (String bankID : validBankIDs) {
            if (bankID.equals(
                    testedCard.getNumber().substring(0, bankID.length()))) {
                isBankIDValid = true;
                break;
            }
        }

        assertTrue(isBankIDValid);
    }

}
