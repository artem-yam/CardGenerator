package com.epam.git.practice.cardModel.mir;

import com.epam.git.practice.cardModel.BasicCard;

/**
 * Class for generating number of Mir Classic cards
 */
public class MirClassicCard extends BasicCard {

    private static final String BANK_ID_NUMBER = "244444";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Mir Classic cards class constructor
     */
    public MirClassicCard() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }
}
