package com.company;

import com.company.cards.cardModel.Card;
import com.company.cards.utils.factory.CardFactory;
import com.company.cards.utils.numberValidator.CardValidator;
import com.company.cards.utils.numberValidator.LuhnValidator;

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
        CardValidator validator = new LuhnValidator();
        for (String typeCard : args) {
            System.out.print("New cards : ");

            Card card = CardFactory.getCard(typeCard.toUpperCase());

            if (card == null) {
                continue;
            }
            String number = card.getNumber();

            System.out.println(card.getClass().getSimpleName() + ": " + number + "\n\t\t\tValid: " + validator.validateCard(number));
        }
    }

}
