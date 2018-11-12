package com.epam.cardgenerator.cardmodel;

import com.epam.cardgenerator.cardmodel.mastercard.Electronic;
import com.epam.cardgenerator.cardmodel.mastercard.Maestro;
import com.epam.cardgenerator.cardmodel.mastercard.Standard;
import com.epam.cardgenerator.cardmodel.mir.Debet;
import com.epam.cardgenerator.cardmodel.mir.Premium;
import com.epam.cardgenerator.cardmodel.visa.Classic;
import com.epam.cardgenerator.cardmodel.visa.Electron;
import com.epam.cardgenerator.cardmodel.visa.Gold;

/**
 * Enum of cards types
 */
public enum CardTypesEnum {

    VISACLASSIC(Classic.class),
    VISAELECTRON(Electron.class),
    VISAGOLD(Gold.class),
    MASTERCARDSTANDARD(Standard.class),
    MASTERCARDELECTRONIC(Electronic.class),
    MASTERCARDMAESTRO(Maestro.class),
    MIRCLASSIC(com.epam.cardgenerator.cardmodel.mir.Classic.class),
    MIRPREMIUM(Premium.class),
    MIRDEBET(Debet.class);

    private Class card;

    /**
     * Constructor of enum values depending on card class
     *
     * @param cardClass - Class of desired enum value
     */
    CardTypesEnum(Class cardClass) {
        this.card = cardClass;
    }

    /**
     * Method for getting card class
     *
     * @return Card class
     */
    public Class getCard() {
        return card;
    }

}
