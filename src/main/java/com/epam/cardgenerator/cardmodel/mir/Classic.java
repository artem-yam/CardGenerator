package com.epam.cardgenerator.cardmodel.mir;

import com.epam.cardgenerator.cardmodel.AbstractCard;

/**
 * Class for generating number of Mir Classic cards
 */
public class Classic extends AbstractCard {

    private static final String BANK_ID_NUMBER = "220044";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Mir Classic cards class constructor
     */
    public Classic() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }
}
