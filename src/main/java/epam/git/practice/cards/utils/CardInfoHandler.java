package epam.git.practice.cards.utils;

import epam.git.practice.cards.cardModel.Card;

/**
 * Class for generating valid cards numbers depending on input cards types
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
