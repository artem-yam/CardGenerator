package com.epam.cardgenerator.cardmodel.mir;

import com.epam.cardgenerator.cardmodel.BasicCard;

/**
 * Class for generating number of Mir Classic cards
 */
public class Classic extends BasicCard {

    private static final String BANK_ID_NUMBER = "244444";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Mir Classic cards class constructor
     */
    public Classic() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }
}
