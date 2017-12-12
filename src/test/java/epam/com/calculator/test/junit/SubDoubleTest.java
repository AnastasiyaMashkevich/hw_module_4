package epam.com.calculator.test.junit;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubDoubleTest extends JunitBaseTest {
    private static final Logger LOG = LogManager.getLogger(SubDoubleTest.class);
    private static final String A = "55.02";
    private static final String B = "102.03";
    private static final String C = "33.05";
    private static final double RESULT = -47.01;
    private double a, b, c;

    @Before
    public void setUp() {
        LOG.info("Sub test is working.");
        a = FormatHelper.convertStringDouble(A);
        b = FormatHelper.convertStringDouble(B);
        c = FormatHelper.convertStringDouble(C);
    }

    @Test
    public void sumTest() {
        Assert.assertTrue("The operation of subtraction is not correct",calculator.sub(a, b) == RESULT);
    }

    @Test
    public void sumNegatTest () {
        Assert.assertTrue("The operation of subtraction is not correct",calculator.sub(a, c) != RESULT);
    }

    @After
    public void shutDown() {
        LOG.info("Sub test is done.");
    }
}
