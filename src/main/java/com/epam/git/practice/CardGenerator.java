package com.epam.git.practice;

import com.epam.git.practice.cardModel.Card;
import com.epam.git.practice.utils.CardFactory;
import com.epam.git.practice.utils.cardInfoHandle.CardInfoHandler;
import com.epam.git.practice.utils.cardInfoHandle.ConsoleCardInfoHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for generating valid cards numbers depending on input cards types
 */
public class CardGenerator {

    private CardInfoHandler cardInfoHandler = new ConsoleCardInfoHandler();

    /**
     * Program entry point
     *
     * @param args program arguments
     */
    public static void main(String[] args) {
        CardGenerator cardGenerator = new CardGenerator();

        List<Card> cardsList = cardGenerator.generateCards(args);


        for (Card card : cardsList) {
            cardGenerator.getCardInfoHandler().outputCardInfo(card);
        }

    }

    /**
     * Method for getting cardInfoHandler
     *
     * @return cardInfoHandler
     */
    public CardInfoHandler getCardInfoHandler() {
        return cardInfoHandler;
    }

    /**
     * Method for generating valid card number depending on input cards types
     *
     * @param cardTypes String with card types
     */
    public List<Card> generateCards(String[] cardTypes) {
        List<Card> cardsList = new ArrayList<Card>();

        for (String cardType : cardTypes) {
            try {
                cardsList.add(CardFactory.getCard(cardType));

            } catch (InstantiationException instantiationException) {
                cardInfoHandler.handleCardError(instantiationException.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                cardInfoHandler.handleCardError(illegalAccessException.getMessage());
            } catch (IllegalArgumentException illegalArgumentException) {
                cardInfoHandler.handleCardError("Incorrect card type: " + cardType);
            }

        }

        return cardsList;
    }

}



