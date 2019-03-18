package com.epam.cardgenerator;

import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.utils.CardFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for generating valid cards numbers depending on input cards types
 */
public class CardGenerator {

    public static final String METHOD_INPUT_MESSAGE =
            "Method \"{}\" input arguments: {}";
    public static final String METHOD_OUTPUT_MESSAGE =
            "Method \"{}\" output value: {}";
    private static final Logger logger = LogManager.getLogger(
            CardGenerator.class);

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

        logger.trace(METHOD_INPUT_MESSAGE,
                "public Card generateCard(String cardType) " +
                        "throws InstantiationException," +
                        "IllegalAccessException", "cardType = " + cardType);

        Card generatedCard = CardFactory.getCard(cardType);

        logger.trace(METHOD_OUTPUT_MESSAGE,
                "public Card generateCard(String cardType) " +
                        "throws InstantiationException," +
                        "IllegalAccessException", generatedCard);

        return generatedCard;
    }

    /**
     * Method for processing cards generation: generating cards depending on
     * input cards types and output their information
     *
     * @param cardTypes String with card types
     */
    public List<Card> processGeneration(String[] cardTypes) {

        if (cardTypes.length != 0) {
            logger.trace(METHOD_INPUT_MESSAGE,
                    "public List<Card> processGeneration" +
                            "(String[] cardTypes)",
                    "cardTypes = " + Arrays.toString(cardTypes));
        } else {
            logger.warn("Input card types are empty");
        }

        List<Card> cardList = new ArrayList<>();

        logger.debug("Starting cards generation: {}",
                Arrays.toString(cardTypes));

        for (String cardType : cardTypes) {
            try {
                Card card = generateCard(cardType);

                logger.info(card);

                cardList.add(card);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException exception) {
                logger.error(exception);
            }
        }

        logger.trace(METHOD_OUTPUT_MESSAGE,
                "public List<Card> processGeneration (String[] cardTypes)",
                cardList);

        return cardList;
    }

    public String getCardNumber(String cardType) {

        logger.trace(METHOD_INPUT_MESSAGE,
                "public String getCardNumber(String cardType)",
                "cardType = " + cardType);

        String number = "";
        try {
            number = generateCard(cardType).getNumber();

        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException exception) {
            logger.error(exception);
        }

        logger.trace(METHOD_OUTPUT_MESSAGE,
                "public String getCardNumber(String cardType)",
                number);

        return number;
    }
}



