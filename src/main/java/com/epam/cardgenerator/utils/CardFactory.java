package com.epam.cardgenerator.utils;

import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.cardmodel.CardTypesEnum;

/**
 * Class-factory for getting cards class instance depending on card type
 */
public class CardFactory {
    private CardFactory() {
    }

    /**
     * Method for getting instance of desired card class
     *
     * @param cardType - Type of desired cards
     * @return - Desired cards
     */
    public static Card getCard(String cardType)
            throws InstantiationException, IllegalAccessException {
        return (Card) CardTypesEnum.valueOf(cardType.toUpperCase())
                .getCard().newInstance();
    }
}

