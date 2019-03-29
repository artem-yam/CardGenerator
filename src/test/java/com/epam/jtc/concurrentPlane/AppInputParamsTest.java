package com.epam.jtc.concurrentPlane;

import com.epam.cardgenerator.CardGenerator;
import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.cardmodel.CardTypesEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
@RunWith(value = Parameterized.class)
public class AppInputParamsTest {

    private static final List<String> availableCardTypes =
            getAvailableCardTypes();

    private String cardType;

    public AppInputParamsTest(String cardType) {
        this.cardType = cardType;
    }

    private static List<String> getAvailableCardTypes() {
        List<String> types = new ArrayList<>();
        for (CardTypesEnum type : CardTypesEnum.values()) {
            types.add(type.toString());
        }

        return types;
    }

    @Parameterized.Parameters
    public static Collection getParameters() {
        return Arrays.asList(
                new String[][]{{"mastercard_electronic"}, {"mastercard_maestro"},
                        {"mastercard_standard"}, {"mir_classic"}, {"mir_debit"},
                        {"mir_premial"}, {"visa_classic"}, {"visa_electron"},
                        {"visa_gold"}, {"11"}, {"mir_gold"},
                        {"wrongType"}});
    }

    @Test
    public void testApplicationInputParameters() {
        try {
            Card card = new CardGenerator().generateCard(cardType);

            Class cardClass = CardTypesEnum.valueOf(cardType.toUpperCase())
                                           .getCard();

            assertTrue(cardClass.isInstance(card));
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException exception) {
            assertTrue(!availableCardTypes.contains(cardType));
        }

    }
}
