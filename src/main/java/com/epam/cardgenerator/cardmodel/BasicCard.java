package com.epam.cardgenerator.cardmodel;

import com.epam.cardgenerator.utils.numbergenerator.LuhnNumberGenerator;
import com.epam.cardgenerator.utils.numbergenerator.NumberGenerator;

/**
 * Basic class of all cards
 */
public abstract class BasicCard implements Card {

    private String bankID;
    private int numberLength;
    private NumberGenerator cardNumberGenerator = new LuhnNumberGenerator();

    /**
     * Method-constructor for basic class of all cards
     *
     * @param bankID       bank id number
     * @param numberLength length of the card number
     */
    public BasicCard(String bankID, int numberLength) {
        this.bankID = bankID;
        this.numberLength = numberLength;
    }

    /**
     * Method for generating card number
     *
     * @return Card number
     */
    @Override
    public String generateNumber() {
        return cardNumberGenerator.generateNumber(bankID, numberLength);
    }
}
