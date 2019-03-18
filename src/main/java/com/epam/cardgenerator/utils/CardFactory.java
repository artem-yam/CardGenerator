package com.epam.cardgenerator.utils;

import com.epam.cardgenerator.CardGenerator;
import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.cardmodel.CardTypesEnum;
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

        logger.trace(CardGenerator.METHOD_INPUT_MESSAGE,
                "public static Card getCard(String typeCard) " +
                        "throws InstantiationException, IllegalAccessException",
                "cardType = " + cardType);

        logger.debug("Trying to get a card of type: {}", cardType);

        Card newCard = (Card) CardTypesEnum.valueOf(cardType.toUpperCase())
                                           .getCard().newInstance();

        logger.trace(CardGenerator.METHOD_OUTPUT_MESSAGE,
                "public static Card getCard(String typeCard) " +
                        "throws InstantiationException, IllegalAccessException",
                newCard);

        return newCard;
    }
}

