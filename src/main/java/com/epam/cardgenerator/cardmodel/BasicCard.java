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
    private String number;

    /**
     * Method-constructor for basic class of all cards
     *
     * @param bankID       bank id number
     * @param numberLength length of the card number
     */
    public BasicCard(String bankID, int numberLength) {
        this.bankID = bankID;
        this.numberLength = numberLength;

        generateNewNumber();

    }

    @Override
    public String getBankID() {
        return bankID;
    }

    @Override
    public int getNumberLength() {
        return numberLength;
    }

    @Override
    public String getNumber() {
        return number;
    }

    /**
     * Method-setter for cardNumberGenerator
     *
     * @param cardNumberGenerator cardNumberGenerator
     */
    public void setCardNumberGenerator(NumberGenerator cardNumberGenerator) {
        this.cardNumberGenerator = cardNumberGenerator;
    }

    /**
     * Method for generating card number
     *
     * @return Card number
     */
    @Override
    public String generateNewNumber() {
        number = cardNumberGenerator.generateNumber(bankID, numberLength);

        return number;
    }

    @Override
    public String toString() {
        return this.getClass().getPackage().getName().
                substring(this.getClass().getPackage().getName()
                        .lastIndexOf('.') + 1) + " " +
                this.getClass().getSimpleName() + ": " + this.getNumber();
    }
}
