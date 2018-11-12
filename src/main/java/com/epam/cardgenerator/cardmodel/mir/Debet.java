package com.epam.cardgenerator.cardmodel.mir;

import com.epam.cardgenerator.cardmodel.BasicCard;

/**
 * Class for generating number of Mir Debet cards
 */
public class Debet extends BasicCard {

    private static final String BANK_ID_NUMBER = "255555";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Mir Debet cards class constructor
     */
    public Debet() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
