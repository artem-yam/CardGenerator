package com.epam.cardgenerator.cardmodel.mir;

import com.epam.cardgenerator.cardmodel.BasicCard;

/**
 * Class for generating number of Mir Premium cards
 */
public class Premium extends BasicCard {

    private static final String BANK_ID_NUMBER = "266666";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Mir Premium cards class constructor
     */
    public Premium() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
