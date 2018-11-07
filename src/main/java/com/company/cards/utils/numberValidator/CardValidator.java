package com.company.cards.utils.numberValidator;

/**
 * Abstract class for cards number validation
 */
public abstract class CardValidator {
    protected CardValidator next;

    /**
     * Method for validating cards number
     *
     * @param cardNumber - Card number for validation
     * @return Result of validation (true - if validation successful, false - if not)
     */
    public abstract boolean validateCard(String cardNumber);
}
