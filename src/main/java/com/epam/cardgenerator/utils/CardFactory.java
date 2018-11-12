package com.epam.cardgenerator.utils;

import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.cardmodel.CardTypesEnum;

/**
 * Class-factory for getting cards class instance depending on card type
 */
public class CardFactory {

    /**
     * Method for getting instance of desired card class
     *
     * @param typeCard - Type of desired cards
     * @return - Desired cards
     */
    public static Card
    getCard(String typeCard) throws InstantiationException, IllegalAccessException, IllegalArgumentException {
        Card card = (Card) CardTypesEnum.valueOf(typeCard.toUpperCase()).getCard().newInstance();

        return card;
    }
}

