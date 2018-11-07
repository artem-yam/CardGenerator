package com.company.cards.utils.factory;

import com.company.cards.cardModel.CardTypesEnum;
import com.company.cards.cardModel.Card;

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
    public static Card getCard(String typeCard) {
        Card card = null;

        try {
            card = (Card) CardTypesEnum.valueOf(typeCard).getCard().newInstance();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            System.out.println("Введен несуществующий тип карты: " + typeCard);
        }

        return card;
    }
}

