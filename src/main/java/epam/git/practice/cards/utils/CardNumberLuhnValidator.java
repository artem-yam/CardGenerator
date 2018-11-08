package epam.git.practice.cards.utils;

/**
 * Class for cards number validation with Luhn algorithm
 */
public class CardNumberLuhnValidator {

    /**
     * Method for validating cards number with Luhn algorithm
     *
     * @param cardNumber - Card number for validation
     * @return Result of validation (true - if validation successful, false - if not)
     */
    public static boolean isCardNumberValid(String cardNumber) {
        int digitsSum = 0;

        String reverse = new StringBuffer(cardNumber).reverse().toString();

        for (int i = 0; i < reverse.length(); i++) {
            int digit = Character.digit(reverse.charAt(i), 10);

            if ((i % 2) == 0)
                digitsSum += digit;
            else {

                digitsSum += 2 * digit;

                if (digit >= 5)
                    digitsSum -= 9;
            }
        }
        return (digitsSum % 10 == 0);
    }
}
