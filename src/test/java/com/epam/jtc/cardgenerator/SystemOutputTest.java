package com.epam.jtc.cardgenerator;

import com.epam.cardgenerator.cardmodel.Card;
import com.epam.cardgenerator.cardmodel.mir.Debit;
import com.epam.cardgenerator.utils.infohandle.ConsoleInfoOutput;
import com.epam.cardgenerator.utils.infohandle.InfoOutput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SystemOutputTest {

    private static final PrintStream systemOutStream = System.out;
    private static final PrintStream systemErrStream = System.err;
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errStream = new ByteArrayOutputStream();
    private InfoOutput infoOutput = new ConsoleInfoOutput();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outStream));
        System.setErr(new PrintStream(errStream));
    }

    @After
    public void cleanUpStream() {
        System.setOut(systemOutStream);
        System.setErr(systemErrStream);
    }

    @Test
    public void testOutputStream() {
        Card card = new Debit();

        infoOutput.outputCardInfo(card);

        String expected = String.format("Card of type \'%s\' with number %s\n",
                "Mir Debit", card.getNumber());

        assertEquals(expected, outStream.toString());

    }

    @Test
    public void testErrorStream() {
        Exception testException = new Exception("Test exception");
        infoOutput.outputCardException(testException);

        String expected = String.format(
                "Can't generate card for some type \n%s\n", testException);

        assertEquals(expected, errStream.toString());
    }
}
