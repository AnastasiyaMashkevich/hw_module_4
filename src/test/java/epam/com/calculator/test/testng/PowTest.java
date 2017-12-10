package epam.com.calculator.test.testng;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PowTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(PowTest.class);
    private static final String A = "5.00";
    private static final String B = "3.00";
    private static final double RESULT = 125.00;
    private double a1, b1;

    @DataProvider(name = "DataProviderForNegativePowTest")
    public Object [] [] paramForNegativePowTest ()
    {
        return new Object[][]{
                {25.00, 2.00, 50.00},
                {7.25, -1.25, 11.00},
                {5.25, 0.00, 4.25},
        };
    }

    @Test(priority = 1)
    public void convertData() {
        LOG.info("'convertData' is working.");
        a1 = FormatHelper.convertStringDouble(A);
        b1 = FormatHelper.convertStringDouble(B);
    }

    @Test( dependsOnMethods = "convertData", priority = 2)
    public void powTest ()
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.pow(a1, b1), RESULT);
        softAssert.assertAll();
    }

    @Test(dataProvider = "DataProviderForNegativePowTest", dependsOnMethods = "convertData", priority = 3)
    public void powNegatTest (double a, double b, double result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(calculator.pow(a, b), result);
        softAssert.assertAll();
    }

    @AfterTest
    public void shutDown() {
        LOG.info("Pow test is done.");
    }
}
