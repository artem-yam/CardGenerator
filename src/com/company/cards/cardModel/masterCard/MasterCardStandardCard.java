package com.company.cards.cardModel.masterCard;

import com.company.cards.cardModel.BasicCard;

/**
 * Class for generating number of MasterCard Standard cards
 */
public class MasterCardStandardCard extends BasicCard {

    private static final String BANK_ID_NUMBER = "533333";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * MasterCard Standard cards class constructor
     */
    public MasterCardStandardCard() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
