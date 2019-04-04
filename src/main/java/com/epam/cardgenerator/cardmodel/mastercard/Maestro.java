package com.epam.cardgenerator.cardmodel.mastercard;

import com.epam.cardgenerator.cardmodel.AbstractCard;

/**
 * Class for generating number of MasterCard Maestro cards
 */
public class Maestro extends AbstractCard {

    private static final String BANK_ID_NUMBER = "522222";
    private static final int CARD_NUMBER_LENGTH = 16;
    /**
     * MasterCard Maestro cards class constructor
     */
    public Maestro() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
