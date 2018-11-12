package com.epam.cardgenerator.cardmodel;

/**
 * Interface for bank cards
 */
public interface Card {

    /**
     * Method for generating card number
     *
     * @return Card number
     */
    String generateNumber();
}
