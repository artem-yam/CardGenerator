package com.epam.cardgenerator.cardmodel.mastercard;

import com.epam.cardgenerator.cardmodel.BasicCard;

/**
 * Class for generating number of MasterCard Maestro cards
 */
public class Maestro extends BasicCard {

    private static final String BANK_ID_NUMBER = "522222";
    private static final int CARD_NUMBER_LENGTH = 18;
    /**
     * MasterCard Maestro cards class constructor
     */
    public Maestro() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
