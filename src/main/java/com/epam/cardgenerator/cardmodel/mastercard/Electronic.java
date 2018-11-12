package com.epam.cardgenerator.cardmodel.mastercard;

import com.epam.cardgenerator.cardmodel.BasicCard;

/**
 * Class for generating number of MasterCard Electronic cards
 */
public class Electronic extends BasicCard {

    private static final String BANK_ID_NUMBER = "511111";
    
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * MasterCard Electronic cards class constructor
     */
    public Electronic() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}

