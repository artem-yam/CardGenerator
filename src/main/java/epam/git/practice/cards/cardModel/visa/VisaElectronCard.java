package epam.git.practice.cards.cardModel.visa;

import epam.git.practice.cards.cardModel.BasicCard;

/**
 * Class for generating number of Visa Electron cards
 */
public class VisaElectronCard extends BasicCard {

    private static final String BANK_ID_NUMBER = "488888";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Visa Electron cards class constructor
     */
    public VisaElectronCard() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }
}
