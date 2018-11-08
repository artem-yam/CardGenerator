package epam.git.practice.cards.cardModel.mir;

import epam.git.practice.cards.cardModel.BasicCard;

/**
 * Class for generating number of Mir Debet cards
 */
public class MirDebetCard extends BasicCard {

    private static final String BANK_ID_NUMBER = "255555";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Mir Debet cards class constructor
     */
    public MirDebetCard() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
