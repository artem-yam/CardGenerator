package com.epam.cardgenerator.cardmodel.visa;

import com.epam.cardgenerator.cardmodel.BasicCard;

/**
 * Class for generating number of Visa Gold cards
 */
public class Gold extends BasicCard {

    private static final String BANK_ID_NUMBER = "499999";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Visa Gold cards class constructor
     */
    public Gold() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
