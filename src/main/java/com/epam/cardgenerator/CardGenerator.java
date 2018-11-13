package com.epam.cardgenerator;

import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.utils.CardFactory;
import com.epam.cardgenerator.utils.infohandle.ConsoleInfoOutput;
import com.epam.cardgenerator.utils.infohandle.InfoOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for generating valid cards numbers depending on input cards types
 */
public class CardGenerator {

    private InfoOutput cardInfoOutput = new ConsoleInfoOutput();

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
     * Method-setter for cardInfoOutput
     *
     * @param cardInfoOutput cardInfoOutput
     */
    public void setCardInfoOutput(InfoOutput cardInfoOutput) {
        this.cardInfoOutput = cardInfoOutput;
    }

    /**
     * Method for output certain card info
     *
     * @param card card
     */
    public void outputCardInfo(Card card) {
        cardInfoOutput.outputCardInfo(card);
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
     * Method for processing cards generation: generating cards depending on input cards types
     * and output their information
     *
     * @param cardTypes String with card types
     */
    public List<Card> processGeneration(String[] cardTypes) {
        List<Card> cardList = new ArrayList<>();

        for (String cardType : cardTypes) {
            try {
                Card card = generateCard(cardType);
                outputCardInfo(card);
                cardList.add(card);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException exception) {
                cardInfoOutput.outputCardException(exception);
            }
        }
        return cardList;
    }

}



