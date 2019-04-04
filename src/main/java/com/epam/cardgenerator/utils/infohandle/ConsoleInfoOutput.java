package com.epam.cardgenerator.utils.infohandle;

import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.cardmodel.mastercard.Electronic;
import com.epam.cardgenerator.cardmodel.mastercard.Maestro;
import com.epam.cardgenerator.cardmodel.mastercard.Standard;
import com.epam.cardgenerator.cardmodel.mir.Debit;
import com.epam.cardgenerator.cardmodel.mir.Premial;
import com.epam.cardgenerator.cardmodel.visa.Electron;
import com.epam.cardgenerator.cardmodel.visa.Gold;

/**
 * Class for handling information about certain card
 */
public class ConsoleInfoOutput implements InfoOutput {

    private static final String CARD_INFO =
            "Card of type \'%s\' with number %s\n";
    private static final String EXCEPTION_MESSAGE =
            "Can't generate card for some type \n%s\n";

    /**
     * Method for printing certain card information: it's name, number, validity
     * check
     *
     * @param card card which info you want to print
     */
    @Override
    public void outputCardInfo(Card card) {
        System.out.printf(CARD_INFO, getCardType(card), card.getNumber());
    }

    private String getCardType(Card card) {
        String type;

        if (card instanceof com.epam.cardgenerator.cardmodel.visa.Classic) {
            type = "Visa Classic";
        } else if (card instanceof Electron) {
            type = "Visa Electron";
        } else if (card instanceof Gold) {
            type = "Visa Gold";
        } else if (card instanceof Standard) {
            type = "Mastercard Standard";
        } else if (card instanceof Electronic) {
            type = "Mastercard Electronic";
        } else if (card instanceof Maestro) {
            type = "Mastercard Maestro";
        } else if (card instanceof com.epam.cardgenerator.cardmodel.mir.Classic) {
            type = "Mir Classic";
        } else if (card instanceof Premial) {
            type = "Mir Premial";
        } else if (card instanceof Debit) {
            type = "Mir Debit";
        } else {
            throw new IllegalArgumentException(
                    "Card of unexpected type" + card.getClass());
        }

        return type;
    }

    /**
     * Method for output exception
     *
     * @param exception exception for output
     */
    @Override
    public void outputCardException(Exception exception) {
        System.err.printf(EXCEPTION_MESSAGE, exception);
    }
}
