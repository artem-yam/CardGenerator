package epam.git.practice.cards.utils;

import epam.git.practice.cards.cardModel.CardTypesEnum;
import epam.git.practice.cards.cardModel.Card;

/**
 * Class-factory for getting cards class instance depending on cards type
 */
public class CardFactory {

    /**
     * Method for getting instance of desired cards class
     *
     * @param typeCard - Type of desired cards
     * @return - Desired cards
     */
    public static Card getCard(String typeCard) throws IllegalArgumentException {
        Card card = null;

        try {
            card = (Card) CardTypesEnum.valueOf(typeCard).getCard().newInstance();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }

        return card;
    }
}

