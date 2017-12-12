package epam.com.calculator.test.testng;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DivLongTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(DivLongTest.class);

    @BeforeTest
    public void setUp() {
        LOG.info("Div test is working.");
    }

    @DataProvider(name = "DataProviderForDivTest")
    public Object [] [] paramForDivTest () {
        return new Object[][]{
                {"100", "2", "50"},
                {"-100", "2", "-50"},
                new Object[]{"200", "200", "1"},
        };
    }

    @DataProvider(name = "DataProviderForNegativeDivTest")
    public Object [] [] paramForNegativeDivTest () {
        return new Object[][]{
                {100, 120, 50},
                {50, -155, 1},
                {-141, -5522, 20},
        };
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divByZeroTest() throws NumberFormatException {
        calculator.div(25, 0L);
    }

    @Test(dataProvider = "DataProviderForDivTest", groups = {"Debug"})
    public void divTest (String a, String b, String result) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.div(FormatHelper.convertStringLong(a), FormatHelper.convertStringLong(b)),
                FormatHelper.convertStringLong(result));
        softAssert.assertAll();
    }

    @Test(dataProvider = "DataProviderForNegativeDivTest", groups = {"Debug"})
    public void divNegatTest (long a, long b, long result) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(calculator.div(a, b), result, "Division operation is not correct");
        softAssert.assertAll();
    }

    @AfterTest
    public void shutDown() {
        LOG.info("Div test is done.");
    }
}
