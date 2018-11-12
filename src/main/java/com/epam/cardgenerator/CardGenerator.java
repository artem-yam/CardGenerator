package com.epam.cardgenerator;

import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.utils.CardFactory;
import com.epam.cardgenerator.utils.infohandle.CardInfoOutput;
import com.epam.cardgenerator.utils.infohandle.ConsoleCardInfoHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for generating valid cards numbers depending on input cards types
 */
public class CardGenerator {

    private CardInfoOutput cardInfoHandler = new ConsoleCardInfoHandler();

    /**
     * Program entry point
     *
     * @param args program arguments
     */
    public static void main(String[] args) {
        CardGenerator cardGenerator = new CardGenerator();
        cardGenerator.processGeneration(args);
    }

    /**
     * Method for output certain card info
     *
     * @param card card
     */
    public void outputCardInfo(Card card) {
        cardInfoHandler.outputCardInfo(card);
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
    public Card generateCard(String cardType) throws InstantiationException,
            IllegalAccessException, IllegalArgumentException {
        Card card = CardFactory.getCard(cardType);

        return card;
    }

    /**
     * Method for processing cards numbergenerator: generating cards depending on input cards types
     * and output their information
     *
     * @param cardTypes String with card types
     */
    public void processGeneration(String[] cardTypes) {
        List<Card> cardsList = new ArrayList<Card>();

        for (String cardType : cardTypes) {
            try {

                cardsList.add(generateCard(cardType));


            } catch (InstantiationException instantiationException) {
                cardInfoHandler.outputCardException(instantiationException);
            } catch (IllegalAccessException illegalAccessException) {
                cardInfoHandler.outputCardException(illegalAccessException);
            } catch (IllegalArgumentException illegalArgumentException) {
                cardInfoHandler.outputCardException(illegalArgumentException);
            }

        }

        for (Card card : cardsList) {
            outputCardInfo(card);
        }
    }

}



