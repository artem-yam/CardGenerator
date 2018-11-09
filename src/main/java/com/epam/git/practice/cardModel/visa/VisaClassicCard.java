package com.epam.git.practice.cardModel.visa;

import com.epam.git.practice.cardModel.BasicCard;

/**
 * Class for generating number of Visa Classic cards
 */
public class VisaClassicCard extends BasicCard {

    private static final String BANK_ID_NUMBER = "477777";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Visa Classic cards class constructor
     */
    public VisaClassicCard() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }
}
