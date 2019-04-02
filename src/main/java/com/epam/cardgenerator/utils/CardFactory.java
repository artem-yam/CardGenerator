package com.epam.cardgenerator.utils;

import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.cardmodel.CardType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class-factory for getting cards class instance depending on card type
 */
public class CardFactory {

    private static final Logger logger = LogManager.getLogger(
            CardFactory.class);

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

        logger.debug("Trying to get a card of type: {}", cardType);

        Card newCard = (Card) CardType.valueOf(cardType.toUpperCase())
                                           .getCard().newInstance();

        logger.debug("Generated card: {} {}", cardType, newCard.getNumber());

        return newCard;
    }
}

