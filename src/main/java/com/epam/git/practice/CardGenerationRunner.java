package com.epam.git.practice;

import com.epam.git.practice.utils.CardGenerator;

/**
 * Class for generating valid cards numbers depending on input cards types
 */
public class CardGenerationRunner {

    /**
     * Method for generating valid cards numbers depending on input cards types
     *
     * @param args String with cards types
     */
    public static void main(String[] args) {

        for (String typeCard : args) {
            CardGenerator.generateCard(typeCard);
        }
    }
}



