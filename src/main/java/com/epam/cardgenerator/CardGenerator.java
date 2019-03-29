package com.epam.cardgenerator;

import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.utils.CardFactory;
import com.epam.cardgenerator.utils.infohandle.ConsoleInfoOutput;
import com.epam.cardgenerator.utils.infohandle.InfoOutput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for generating valid cards numbers depending on input cards types
 */
public class CardGenerator {

    private static final Logger logger = LogManager.getLogger(
            CardGenerator.class);

    private InfoOutput infoOutput = new ConsoleInfoOutput();

    /**
     * Program entry point
     *
     * @param args program arguments
     */
    public static void main(String[] args) {
        new CardGenerator().processGeneration(args);
    }

    /**
     * Method for generating certain card class instance depending on card type
     *
     * @param cardType card type
     * @return generated card
     * @throws InstantiationException   InstantiationException
     * @throws IllegalAccessException   IllegalAccessException
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public Card generateCard(String cardType)
            throws InstantiationException, IllegalAccessException {

        return CardFactory.getCard(cardType);
    }

    /**
     * Method for processing cards generation: generating cards depending on
     * input cards types and output their information
     *
     * @param cardTypes String with card types
     */
    public List<Card> processGeneration(String[] cardTypes) {

        logger.debug("Starting cards generation: {}",
                Arrays.toString(cardTypes));

        if (cardTypes.length == 0) {
            logger.warn("Input card types are empty");
        }

        List<Card> cardList = new ArrayList<>();

        for (String cardType : cardTypes) {
            try {
                Card card = generateCard(cardType);

                infoOutput.outputCardInfo(card);

                cardList.add(card);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException exception) {
                logger.error("Can't generate card for type " + cardType,
                        exception);
            }
        }

        logger.debug("Generated cards:{}", cardList);

        return cardList;
    }

    public String getCardNumber(String cardType) {

        logger.debug("Trying to get number for card of type \'{}\'", cardType);

        String number = null;
        try {
            number = generateCard(cardType).getNumber();

        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException exception) {
            logger.error(exception);
        }

        logger.debug("Card number: {}", number);

        return number;
    }
}



