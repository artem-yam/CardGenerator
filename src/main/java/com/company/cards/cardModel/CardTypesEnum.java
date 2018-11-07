package com.company.cards.cardModel;

import com.company.cards.cardModel.masterCard.MasterCardElectronicCard;
import com.company.cards.cardModel.masterCard.MasterCardMaestroCard;
import com.company.cards.cardModel.masterCard.MasterCardStandardCard;
import com.company.cards.cardModel.mir.MirClassicCard;
import com.company.cards.cardModel.mir.MirDebetCard;
import com.company.cards.cardModel.mir.MirPremiumCard;
import com.company.cards.cardModel.visa.VisaClassicCard;
import com.company.cards.cardModel.visa.VisaElectronCard;
import com.company.cards.cardModel.visa.VisaGoldCard;

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
