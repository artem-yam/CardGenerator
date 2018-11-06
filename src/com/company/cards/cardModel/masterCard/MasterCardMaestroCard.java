package com.company.cards.cardModel.masterCard;

import com.company.cards.cardModel.BasicCard;

/**
 * Class for generating number of MasterCard Maestro cards
 */
public class MasterCardMaestroCard extends BasicCard {

    private static final String BANK_ID_NUMBER = "522222";
    private static final int CARD_NUMBER_LENGTH = 18;
    /**
     * MasterCard Maestro cards class constructor
     */
    public MasterCardMaestroCard() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
