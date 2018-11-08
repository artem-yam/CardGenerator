package epam.git.practice.cards.cardModel.mir;

import epam.git.practice.cards.cardModel.BasicCard;

/**
 * Class for generating number of Mir Premium cards
 */
public class MirPremiumCard extends BasicCard {

    private static final String BANK_ID_NUMBER = "266666";
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Mir Premium cards class constructor
     */
    public MirPremiumCard() {
        super(BANK_ID_NUMBER, CARD_NUMBER_LENGTH);
    }

}
