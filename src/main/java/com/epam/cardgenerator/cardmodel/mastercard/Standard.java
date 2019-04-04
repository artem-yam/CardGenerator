package com.epam.cardgenerator.cardmodel.mastercard;

import com.epam.cardgenerator.cardmodel.AbstractCard;

/**
 * Class for generating number of MasterCard Standard cards
 */
public class Standard extends AbstractCard {

    private static final String BANK_ID_NUMBER = "533333";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * MasterCard Standard cards class constructor
     */
    public Standard() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
