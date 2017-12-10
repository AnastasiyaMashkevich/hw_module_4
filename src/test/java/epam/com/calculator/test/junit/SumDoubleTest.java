package epam.com.calculator.test.junit;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;

public class SumDoubleTest extends JunitBaseTest {
    private static final Logger LOG = LogManager.getLogger(SumDoubleTest.class);
    private static final String A = "55.02";
    private static final String B = "102.03";
    private static final String C = "33.05";
    private static final double RESULT = 157.05;
    private double a, b, c;

    @Before
    public void setUp() {
        LOG.info("Sum test is working.");
        a = FormatHelper.convertStringDouble(A);
        b = FormatHelper.convertStringDouble(B);
        c = FormatHelper.convertStringDouble(C);
    }

    @Test
    public void sumTest()
    {
        Assert.assertTrue(calculator.sum(a, b) == RESULT);
    }

    @Test
    public void sumNegatTest () {
        Assert.assertNotSame(calculator.sum(a, c), RESULT);
    }

    @After
    public void shutDown() {
        LOG.info("Sum test is done.");
    }
}
