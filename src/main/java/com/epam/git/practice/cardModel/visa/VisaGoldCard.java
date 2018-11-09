package com.epam.git.practice.cardModel.visa;

import com.epam.git.practice.cardModel.BasicCard;

/**
 * Class for generating number of Visa Gold cards
 */
public class VisaGoldCard extends BasicCard {

    private static final String BANK_ID_NUMBER = "499999";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Visa Gold cards class constructor
     */
    public VisaGoldCard() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
