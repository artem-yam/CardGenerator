package com.epam.cardgenerator.utils.infohandle;

import com.epam.cardgenerator.cardmodel.Card;

/**
 * Class for handling information about certain card
 */
public class ConsoleInfoOutput implements InfoOutput {

    /**
     * Method for printing certain card information: it's name, number, validity check
     *
     * @param card card which info you want to print
     */
    @Override
    public void outputCardInfo(Card card) {
        System.out.println(card.getClass().getPackage().getName().
                substring(card.getClass().getPackage().getName().lastIndexOf(".") + 1)
                + " " + card.getClass().getSimpleName() + ": " + card.generateNumber());
    }

    /**
     * Method for output exception
     *
     * @param exception exception for output
     */
    @Override
    public void outputCardException(Exception exception) {
        System.err.println(exception.getMessage());
    }
}