package com.epam.git.practice.utils.cardInfoHandle;

import com.epam.git.practice.cardModel.Card;

/**
 * Class for handling information about certain card
 */
public class ConsoleCardInfoHandler implements CardInfoHandler {

    /**
     * Method for printing certain card information: it's name, number, validity check
     *
     * @param card card which info you want to print
     */
    @Override
    public void outputCardInfo(Card card) {
        System.out.println(card.getClass().getSimpleName() + ": " + card.generateNumber());
    }

    /**
     * Method for handling some error
     *
     * @param errorMessages error messages for handle
     */
    @Override
    public void handleCardError(String... errorMessages) {
        for (String message : errorMessages) {
            System.err.println(message);
        }
    }
}
