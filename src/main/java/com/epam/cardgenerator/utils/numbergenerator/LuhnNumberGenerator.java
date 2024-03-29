package com.epam.cardgenerator.utils.numbergenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.SecureRandom;

/**
 * Class for generating card number depending on BIN and number length
 */
public class LuhnNumberGenerator implements NumberGenerator {

    private static final Logger logger = LogManager.getLogger(
            LuhnNumberGenerator.class);

    private static final SecureRandom RND = new SecureRandom();
    private static final int RADIX = 10;
    private static final int EVEN_CHECK = 2;

    /**
     * Method to get last digit of card number with Luhn algorithm
     *
     * @param cardNumber card number without last digit
     * @return correct last digit
     */
    private static int getCheckDigit(String cardNumber) {

        logger.debug("Computing check digit for number {}", cardNumber);

        int sum = 0;
        int numberRest = ((cardNumber.length() % EVEN_CHECK) == 0) ? 1 : 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            int digit = Integer.parseInt(cardNumber.substring(i, i + 1));

            if ((i % EVEN_CHECK) == numberRest) {
                digit = digit * EVEN_CHECK;

                if (digit > RADIX - 1) {
                    digit -= RADIX - 1;
                }
            }
            sum += digit;
        }

        int mod = sum % RADIX;

        int checkDigit = (mod == 0) ? 0 : RADIX - mod;

        logger.debug("Check digit = {}", checkDigit);

        return checkDigit;
    }

    /**
     * Method for generating cards number
     *
     * @param bankIdNumber - Bank Identification Number (first six digits of
     *                     generating number)
     * @param numberLength - Length of generating number
     * @return Generated cards number
     */
    @Override
    public String generateNumber(String bankIdNumber, int numberLength) {

        logger.debug("Generating new number. Bank ID = {} , Number length = {}",
                bankIdNumber, numberLength);

        int randomNumberLength = numberLength - bankIdNumber.length() - 1;

        StringBuilder builder = new StringBuilder(bankIdNumber);

        for (int i = 0; i < randomNumberLength; i++) {
            builder.append(RND.nextInt(RADIX));
        }

        builder.append(getCheckDigit(builder.toString()));

        logger.debug("Generated number: {}", builder);

        return builder.toString();
    }
}
