package com.epam.jtc.cardgenerator;

import com.epam.cardgenerator.CardGenerator;
import com.epam.cardgenerator.cardmodel.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
@RunWith(value = Parameterized.class)
public class AppInputParamsTest {

    private static final List<String> validCardTypes =
            getValidCardTypes();

    private String cardType;

    public AppInputParamsTest(String cardType) {
        this.cardType = cardType;
    }

    private static List<String> getValidCardTypes() {
        List<String> types = new ArrayList<>();
        for (CardTypeForTest type : CardTypeForTest.values()) {
            types.add(type.toString());
        }

        return types;
    }

    @Parameterized.Parameters
    public static Collection getParameters() {
        List<String[]> parameters = new ArrayList<>();

        for (CardTypeForTest value : CardTypeForTest.values()) {
            parameters.add(new String[]{value.toString()});
        }
        parameters.add(new String[]{"11"});
        parameters.add(new String[]{"mir_gold"});
        parameters.add(new String[]{"wrongType"});

        return parameters;
    }

    @Test
    public void testApplicationInputParameters() {
        try {
            Card card = new CardGenerator().generateCard(cardType);

            Class cardClass = com.epam.cardgenerator.cardmodel.CardType.valueOf(
                    cardType.toUpperCase()).getCard();

            assertTrue(cardClass.isInstance(card));
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException exception) {
            assertTrue(!validCardTypes.contains(cardType));
        }

    }
}
