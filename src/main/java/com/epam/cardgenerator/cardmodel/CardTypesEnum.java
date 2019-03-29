package com.epam.cardgenerator.cardmodel;

import com.epam.cardgenerator.cardmodel.mastercard.Electronic;
import com.epam.cardgenerator.cardmodel.mastercard.Maestro;
import com.epam.cardgenerator.cardmodel.mastercard.Standard;
import com.epam.cardgenerator.cardmodel.mir.Debit;
import com.epam.cardgenerator.cardmodel.mir.Premial;
import com.epam.cardgenerator.cardmodel.visa.Electron;
import com.epam.cardgenerator.cardmodel.visa.Gold;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Enum of cards types
 */
public enum CardTypesEnum {

    VISA_CLASSIC(com.epam.cardgenerator.cardmodel.visa.Classic.class),
    VISA_ELECTRON(Electron.class),
    VISA_GOLD(Gold.class),
    MASTERCARD_STANDARD(Standard.class),
    MASTERCARD_ELECTRONIC(Electronic.class),
    MASTERCARD_MAESTRO(Maestro.class),
    MIR_CLASSIC(com.epam.cardgenerator.cardmodel.mir.Classic.class),
    MIR_PREMIAL(Premial.class),
    MIR_DEBIT(Debit.class);

    private static final Logger logger = LogManager.getLogger(
            CardTypesEnum.class);
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
        logger.debug("Card class: {}", card);

        return card;
    }

}
