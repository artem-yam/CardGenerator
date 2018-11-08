package epam.git.practice.cards.cardModel;

import epam.git.practice.cards.utils.CardNumberGenerator;

/**
 * Basic class for all cards
 */
public abstract class BasicCard implements Card {

    protected String bankID;
    protected int numberLength;
    private CardNumberGenerator cardNumberGenerator;


    public BasicCard(String bankID, int numberLength) {
        this.bankID = bankID;
        this.numberLength = numberLength;

        this.cardNumberGenerator = new CardNumberGenerator();
    }

    /**
     * Method for getting cards number
     *
     * @return Card number
     */
    @Override
    public String getNumber() {
        return cardNumberGenerator.generate(bankID, numberLength);
    }
}
