package epam.com.calculator.test.testng;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SubLongTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(SubLongTest.class);

    @BeforeTest
    public void setUp() {
        LOG.info("Sub test is working.");
    }

    @DataProvider(name = "DataProviderForSubTest")
    public Object [] [] paramForSubTest ()
    {
        return new Object[][]{
                {"10000000000", "2", "9999999998"},
                {"-10000000000", "2", "-10000000002"},
                new Object[]{"10000000000", "20000000000", "-10000000000"},
        };
    }

    @DataProvider(name = "DataProviderForNegativeSubTest")
    public Object [] [] paramForNegativeSubTest ()
    {
        return new Object[][]{
                {10000000000L, 12000000000L, 5000000},
                {5001005000L, -155215454546L, 11},
                {-14105558850252L, -55222221054L, 20},
        };
    }

    @Test(dataProvider = "DataProviderForSubTest")
    public void subTest (String a, String b, String result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.sub(FormatHelper.convertStringLong(a), FormatHelper.convertStringLong(b)),
                FormatHelper.convertStringLong(result));
        softAssert.assertAll();
    }

    @Test(dataProvider = "DataProviderForNegativeSubTest", dependsOnMethods = "subTest")
    public void subNegatTest (long a, long b, long result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(calculator.sub(a, b), result);
        softAssert.assertAll();
    }

    @AfterTest
    public void shutDown() {
        LOG.info("Sub test is done.");
    }
}
