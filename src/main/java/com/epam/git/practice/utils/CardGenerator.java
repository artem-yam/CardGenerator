package com.epam.git.practice.utils;

import com.epam.git.practice.cardModel.Card;

/**
 * Class for generating valid card number depending on input cards types
 */
public class CardGenerator {

    /**
     * Method for generating valid card number depending on input cards types
     *
     * @param cardType String with cards types
     */
    public static void generateCard(String cardType) {

        Card card;

        try {
            card = CardFactory.getCard(cardType.toUpperCase());

            CardInfoHandler.printCardInfo(card);
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            System.out.println("Incorrect card type: " + cardType);
        }


    }
}



