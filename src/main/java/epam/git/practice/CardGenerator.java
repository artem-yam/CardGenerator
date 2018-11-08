package epam.git.practice;

import epam.git.practice.cards.cardModel.Card;
import epam.git.practice.cards.utils.CardInfoHandler;
import epam.git.practice.cards.utils.CardFactory;

/**
 * Class for generating valid cards numbers depending on input cards types
 */
public class CardGenerator {

    /**
     * Method for generating valid cards numbers depending on input cards types
     *
     * @param args - String with cards types
     */
    public static void main(String[] args) {

        for (String typeCard : args) {
            Card card;

            try {
                card = CardFactory.getCard(typeCard.toUpperCase());

                CardInfoHandler.printCardInfo(card);
            } catch (IllegalArgumentException e) {
                System.out.println("Введен несуществующий тип карты: " + typeCard);
            }

        }

    }
}
