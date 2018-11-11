package com.epam.git.practice.utils.cardInfoHandle;

import com.epam.git.practice.cardModel.Card;

/**
 * Class for handling information about certain card
 */
public interface CardInfoHandler {

    /**
     * Method for printing certain card information: it's name, number, validity check
     *
     * @param card card which info you want to print
     */
    void outputCardInfo(Card card);

    /**
     * Method for handling some error
     *
     * @param errorMessages error messages for handle
     */
    void handleCardError(String... errorMessages);
}

