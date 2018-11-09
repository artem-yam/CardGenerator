package com.epam.git.practice.cardModel;

import com.epam.git.practice.cardModel.mir.MirClassicCard;
import com.epam.git.practice.cardModel.mir.MirDebetCard;
import com.epam.git.practice.cardModel.mir.MirPremiumCard;
import com.epam.git.practice.cardModel.visa.VisaElectronCard;
import com.epam.git.practice.cardModel.masterCard.MasterCardElectronicCard;
import com.epam.git.practice.cardModel.masterCard.MasterCardMaestroCard;
import com.epam.git.practice.cardModel.masterCard.MasterCardStandardCard;
import com.epam.git.practice.cardModel.visa.VisaClassicCard;
import com.epam.git.practice.cardModel.visa.VisaGoldCard;

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
