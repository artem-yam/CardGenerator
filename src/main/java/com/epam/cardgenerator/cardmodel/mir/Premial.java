package com.epam.cardgenerator.cardmodel.mir;

import com.epam.cardgenerator.cardmodel.AbstractCard;

/**
 * Class for generating number of Mir Premial cards
 */
public class Premial extends AbstractCard {

    private static final String BANK_ID_NUMBER = "220066";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Mir Premial cards class constructor
     */
    public Premial() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
