package epam.git.practice.cards.cardModel;

import epam.git.practice.cards.cardModel.masterCard.MasterCardElectronicCard;
import epam.git.practice.cards.cardModel.masterCard.MasterCardMaestroCard;
import epam.git.practice.cards.cardModel.masterCard.MasterCardStandardCard;
import epam.git.practice.cards.cardModel.mir.MirClassicCard;
import epam.git.practice.cards.cardModel.mir.MirDebetCard;
import epam.git.practice.cards.cardModel.mir.MirPremiumCard;
import epam.git.practice.cards.cardModel.visa.VisaClassicCard;
import epam.git.practice.cards.cardModel.visa.VisaElectronCard;
import epam.git.practice.cards.cardModel.visa.VisaGoldCard;

/**
 * Enum of cards types
 */
public enum CardTypesEnum {

    VISACLASSIC(VisaClassicCard.class),
    VISAELECTRON(VisaElectronCard.class),
    VISAGOLD(VisaGoldCard.class),
    MASTERCARDSTANDARD(MasterCardStandardCard.class),
    MASTERCARDELECTRONIC(MasterCardElectronicCard.class),
    MASTERCARDMAESTRO(MasterCardMaestroCard.class),
    MIRCLASSIC(MirClassicCard.class),
    MIRPREMIUM(MirPremiumCard.class),
    MIRDEBET(MirDebetCard.class);

    private Class card;

    /**
     * Constructor of enum values depending on cards class
     *
     * @param cardClass - Class of desired enum value
     */
    CardTypesEnum(Class cardClass) {
        this.card = cardClass;
    }

    /**
     * Method for getting cards class
     *
     * @return Card class
     */
    public Class getCard() {
        return card;
    }

}
