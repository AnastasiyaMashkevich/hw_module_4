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
    public Object [] [] paramForDivTest ()
    {
        return new Object[][]{
                {"10000000000", "2", "5000000000"},
                {"-10000000000", "2", "-5000000000"},
                new Object[]{"20000000000", "20000000000", "1"},
        };
    }

    @DataProvider(name = "DataProviderForNegativeDivTest")
    public Object [] [] paramForNegativeDivTest ()
    {
        return new Object[][]{
                {10000000000L, 12000000000L, 5000000},
                {5001005000L, -155215454546L, 11},
                {-14105558850252L, -55222221054L, 20},
        };
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divByZeroTest() throws NumberFormatException {
        calculator.div(2504543212L, 0L);
    }

    @Test(dataProvider = "DataProviderForDivTest")
    public void divTest (String a, String b, String result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.div(FormatHelper.convertStringLong(a), FormatHelper.convertStringLong(b)),
                FormatHelper.convertStringLong(result));
        softAssert.assertAll();
    }

    @Test(dataProvider = "DataProviderForNegativeDivTest")
    public void divNegatTest (long a, long b, long result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(calculator.div(a, b), result);
        softAssert.assertAll();
    }

    @AfterTest
    public void shutDown() {
        LOG.info("Div test is done.");
    }
}
