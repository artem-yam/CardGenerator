package com.company.cards.cardModel;

import com.company.cards.utils.numberGenerator.NumberGenerator;

/**
 * Basic class for all cards
 */
public abstract class BasicCard implements Card {

    protected String bankID;
    protected int numberLength;
    private NumberGenerator cardNumberGenerator;


    public BasicCard(String bankID, int numberLength) {
        this.bankID = bankID;
        this.numberLength = numberLength;

        this.cardNumberGenerator = new NumberGenerator();
    }

    /**
     * Method for getting cards number
     *
     * @return Card number
     */
    @Override
    public String getNumber() {
        return cardNumberGenerator.generate(bankID, numberLength);
    }
}
