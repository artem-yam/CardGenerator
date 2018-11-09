package com.epam.git.practice.utils;

import com.epam.git.practice.cardModel.Card;

/**
 * Class for handling information about certain card
 */
public class CardInfoHandler {

    /**
     * Method for printing certain card information: it's name, number, validity check
     *
     * @param card card which info you want to print
     */
    public static void printCardInfo(Card card) {
        System.out.println(card.getClass().getSimpleName() + ": " + card.getNumber() + "\n\tValid: "
                + CardNumberLuhnValidator.isCardNumberValid(card.getNumber()));
    }
}
