package epam.com.calculator.test.junit;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivDoubleTest extends JunitBaseTest {
    private static final Logger LOG = LogManager.getLogger(DivDoubleTest.class);
    private static final String A = "15.00";
    private static final String B = "3.00";
    private static final String C = "33.05";
    private static final double RESULT = 5.00;
    private double a, b, c;

    @Before
    public void setUp() {
        LOG.info("Div test is working.");
        a = FormatHelper.convertStringDouble(A);
        b = FormatHelper.convertStringDouble(B);
        c = FormatHelper.convertStringDouble(C);
    }

    @Test(expected = NumberFormatException.class)
    public void divByZeroTest() throws NumberFormatException {
        calculator.div(a, 0.00);
    }

    @Test
    public void divTest() {
        Assert.assertTrue("Division operation is not correct", calculator.div(a, b) == RESULT);
    }

    @Test
    public void divNegatTest () {
        Assert.assertTrue("Division operation is not correct",calculator.div(a, c) != RESULT);
    }

    @After
    public void shutDown() {
        LOG.info("Div test is done.");
    }
}
