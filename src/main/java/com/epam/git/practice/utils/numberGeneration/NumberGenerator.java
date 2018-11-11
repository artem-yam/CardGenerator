package com.epam.git.practice.utils.numberGeneration;

/**
 * Interface for generating card number
 */
public interface NumberGenerator {

    /**
     * Method for generating card number
     *
     * @param bankIdNumber - Bank Identification Number (first six digits of generating number)
     * @param numberLength - Length of generating number
     * @return Generated cards number
     */
    String generateNumber(String bankIdNumber, int numberLength);

}
