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
        CardGenerator cardGenerator = new CardGenerator();
        try {
            cardGenerator.processGeneration(args);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException exception) {
            cardGenerator.infoOutput.outputCardException(exception);
            logger.error("Can't generate card for some type ", exception);
        }
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
            throws InstantiationException, IllegalAccessException,
            IllegalArgumentException {

        return CardFactory.getCard(cardType);
    }

    /**
     * Method for processing cards generation: generating cards depending on
     * input cards types and output their information
     *
     * @param cardTypes String with card types
     */
    public List<Card> processGeneration(String[] cardTypes)
            throws InstantiationException, IllegalAccessException,
            IllegalArgumentException {

        logger.debug("Starting cards generation: {}",
                Arrays.toString(cardTypes));

        if (cardTypes.length == 0) {
            logger.warn("Input card types are empty");
        }

        List<Card> cardList = new ArrayList<>();

        for (String cardType : cardTypes) {

            Card card = generateCard(cardType);

            infoOutput.outputCardInfo(card);

            cardList.add(card);

        }

        logger.debug("Generated cards:{}", cardList);

        return cardList;
    }

    public String getCardNumber(String cardType)
            throws InstantiationException, IllegalAccessException,
            IllegalArgumentException {

        logger.debug("Trying to get number for card of type \'{}\'", cardType);

        String number = generateCard(cardType).getNumber();

        logger.debug("Card number: {}", number);

        return number;
    }
}