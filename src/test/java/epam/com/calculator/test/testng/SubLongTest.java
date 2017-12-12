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
    public Object [] [] paramForSubTest () {
        return new Object[][]{
                {"100", "2", "98"},
                {"-10", "2", "-12"},
                new Object[]{"100", "200", "-100"},
        };
    }

    @DataProvider(name = "DataProviderForNegativeSubTest")
    public Object [] [] paramForNegativeSubTest () {
        return new Object[][]{
                {100, 12, 5},
                {5001, -15, 11},
                {-14105, -5522, 20},
        };
    }

    @Test(dataProvider = "DataProviderForSubTest", groups = {"Debug"})
    public void subTest (String a, String b, String result) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.sub(FormatHelper.convertStringLong(a), FormatHelper.convertStringLong(b)),
                FormatHelper.convertStringLong(result), "The operation of subtraction is not correct");
        softAssert.assertAll();
    }

    @Test(dataProvider = "DataProviderForNegativeSubTest", dependsOnMethods = "subTest", groups = {"Debug"})
    public void subNegatTest (long a, long b, long result) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(calculator.sub(a, b), result, "The operation of subtraction is not correct");
        softAssert.assertAll();
    }

    @AfterTest
    public void shutDown() {
        LOG.info("Sub test is done.");
    }
}
