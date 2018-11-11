package com.epam.git.practice.cardModel;

import com.epam.git.practice.utils.numberGeneration.LuhnNumberGenerator;
import com.epam.git.practice.utils.numberGeneration.NumberGenerator;

/**
 * Basic class of all cards
 */
public abstract class BasicCard implements Card {

    private String bankID;
    private int numberLength;
    private NumberGenerator cardNumberGenerator = new LuhnNumberGenerator();
    ;

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
