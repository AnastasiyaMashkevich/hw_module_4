package epam.com.calculator.test.junit;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultDoubleTest extends JunitBaseTest {
    private static final Logger LOG = LogManager.getLogger(MultDoubleTest.class);
    private static final String A = "5.05";
    private static final String B = "3.00";
    private static final String C = "33.05";
    private static final double RESULT = 15.15;
    private double a, b, c;

    @Before
    public void setUp() {
        LOG.info("Mult test is working.");
        a = FormatHelper.convertStringDouble(A);
        b = FormatHelper.convertStringDouble(B);
        c = FormatHelper.convertStringDouble(C);
    }

    @Test
    public void multTest() {
        Assert.assertTrue("The operation of multiplication operation is not correct.There is a bug. Correct result is " + RESULT,
                calculator.mult(a, b) == RESULT);
    }

    @Test
    public void multNegatTest () {
        Assert.assertTrue("The operation of multiplication operation is not correct",
                calculator.mult(a, c) != RESULT);
    }

    @After
    public void shutDown() {
        LOG.info("Mult test is done.");
    }
}
