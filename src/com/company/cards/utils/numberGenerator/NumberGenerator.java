package com.company.cards.utils.numberGenerator;

import java.util.Random;

/**
 * Class for generating cards number depending on BIN and number length
 */
public class NumberGenerator {


    private static final Random RNG = new Random(System.currentTimeMillis());
    private static final int DIGIT_UPPER_LIMIT = 10;

    /**
     * Method for generating cards number
     *
     * @param bankIdNumber - Bank Identification Number (first six digits of generating number)
     * @param NumberLength - Length of generating number
     * @return Generated cards number
     */
    public String generate(String bankIdNumber, int NumberLength) {
        int randomNumberLength = NumberLength - (bankIdNumber.length() - 1);

        StringBuilder builder = new StringBuilder(bankIdNumber);

        for (int i = 0; i < randomNumberLength; i++)
            builder.append(RNG.nextInt(DIGIT_UPPER_LIMIT));

        builder.append(getCheckDigit(builder.toString()));

        return builder.toString();
    }

    private static int getCheckDigit(String numberCard) {
        int sum = 0;
        int numberRest = ((numberCard.length() % 2) == 0) ? 1 : 0;
        for (int i = 0; i < numberCard.length(); i++) {
            int digit = Integer.parseInt(numberCard.substring(i, (i + 1)));

            if ((i % 2) == numberRest) {
                digit = digit * 2;

                if (digit > 9)
                    digit = (digit / 10) + (digit % 10);
            }
            sum += digit;
        }

        int mod = sum % 10;

        return ((mod == 0) ? 0 : 10 - mod);
    }
}
