package epam.com.calculator.test.testng;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IsPositiveTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(IsPositiveTest.class);

    @BeforeTest
    public void setUp() {
        LOG.info("IsPositive test is working.");
    }

    @DataProvider(name = "DataProviderForIsPosTest")
    public Object [] [] paramForIsPosTest () {
        return new Object[][]{
                {"525", true},
                {"65", true},
                {"-552", false},
                new Object[]{"-88", false},
        };
    }

    @Test(dataProvider = "DataProviderForIsPosTest", groups = {"Debug"})
    public void isPositiveTest (String a, boolean result) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.isPositive(FormatHelper.convertStringLong(a)), result, "Number is a negative.");
        softAssert.assertAll();
    }

    @Test(groups = {"Broken"})
    public void isPositiveZeroTest () {
        if(!calculator.isPositive(0L)) {
            Assert.fail("0L is not a positive and not a negative number");
        }
    }



    @AfterTest
    public void shutDown() {
        LOG.info("IsPositive test is done.");
    }
}
