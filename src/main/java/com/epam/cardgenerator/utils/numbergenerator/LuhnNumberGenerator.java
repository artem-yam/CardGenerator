package com.epam.cardgenerator.utils.numbergenerator;

import com.epam.cardgenerator.CardGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/**
 * Class for generating card number depending on BIN and number length
 */
public class LuhnNumberGenerator implements NumberGenerator {

    private static final Logger logger =
            LogManager.getLogger(LuhnNumberGenerator.class);

    private static final Random RND = new Random(System.currentTimeMillis());
    private static final int RADIX = 10;

    /**
     * Method to get last digit of card number with Luhn algorithm
     *
     * @param cardNumber card number without last digit
     * @return correct last digit
     */
    private static int getCheckDigit(String cardNumber) {

        logger.trace(CardGenerator.METHOD_INPUT_MESSAGE,
                "private static int getCheckDigit(String cardNumber)",
                "cardNumber = " + cardNumber);

        int sum = 0;
        int numberRest = ((cardNumber.length() % 2) == 0) ? 1 : 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            int digit = Integer.parseInt(cardNumber.substring(i, (i + 1)));

            if ((i % 2) == numberRest) {
                digit = digit * 2;

                if (digit > 9)
                    digit = (digit / 10) + (digit % 10);
            }
            sum += digit;
        }

        int mod = sum % 10;

        int checkDigit = ((mod == 0) ? 0 : 10 - mod);

        logger.trace(CardGenerator.METHOD_OUTPUT_MESSAGE,
                "private static int getCheckDigit(String cardNumber)",
                checkDigit);

        return checkDigit;
    }

    /**
     * Method for generating cards number
     *
     * @param bankIdNumber - Bank Identification Number (first six digits of generating number)
     * @param numberLength - Length of generating number
     * @return Generated cards number
     */
    @Override
    public String generateNumber(String bankIdNumber, int numberLength) {

        logger.trace(CardGenerator.METHOD_INPUT_MESSAGE,
                "public String generateNumber(String bankIdNumber, " +
                        "int numberLength)",
                String.format("bankIdNumber = %s, numberLength = %d",
                        bankIdNumber, numberLength));

        int randomNumberLength = numberLength - bankIdNumber.length() - 1;

        StringBuilder builder = new StringBuilder(bankIdNumber);

        for (int i = 0; i < randomNumberLength; i++) {
            builder.append(RND.nextInt(RADIX));
        }

        builder.append(getCheckDigit(builder.toString()));

        logger.trace(CardGenerator.METHOD_OUTPUT_MESSAGE,
                "public String generateNumber(String bankIdNumber, " +
                        "int numberLength)",
                builder);

        return builder.toString();
    }
}
