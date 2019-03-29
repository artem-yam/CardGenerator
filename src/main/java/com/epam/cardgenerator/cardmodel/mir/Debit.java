package com.epam.cardgenerator.cardmodel.mir;

import com.epam.cardgenerator.cardmodel.BasicCard;

/**
 * Class for generating number of Mir Debit cards
 */
public class Debit extends BasicCard {

    private static final String BANK_ID_NUMBER = "255555";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Mir Debit cards class constructor
     */
    public Debit() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
