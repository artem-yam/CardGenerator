package com.epam.cardgenerator.cardmodel.visa;

import com.epam.cardgenerator.cardmodel.BasicCard;

/**
 * Class for generating number of Visa Electron cards
 */
public class Electron extends BasicCard {

    private static final String BANK_ID_NUMBER = "488888";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Visa Electron cards class constructor
     */
    public Electron() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }
}
