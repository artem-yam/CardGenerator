package com.company.cards.cardModel.masterCard;

import com.company.cards.cardModel.BasicCard;

/**
 * Class for generating number of MasterCard Electronic cards
 */
public class MasterCardElectronicCard extends BasicCard {

    private static final String BANK_ID_NUMBER = "511111";
    
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * MasterCard Electronic cards class constructor
     */
    public MasterCardElectronicCard() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}

