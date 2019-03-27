package com.epam.jtc.concurrentPlane;

import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.cardmodel.mir.Classic;
import com.epam.cardgenerator.utils.infohandle.ConsoleInfoOutput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SystemOutputTest {

    private static final PrintStream consoleStream = System.out;
    private final ByteArrayOutputStream outputStream =
            new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUpStream() {
        System.setOut(consoleStream);
    }

    @Test
    public void out() {
        Card card = new Classic();

        new ConsoleInfoOutput().outputCardInfo(card);

        String expected = card.toString() + System.lineSeparator();

        assertEquals(expected, outputStream.toString());
    }

}
