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
    public Object [] [] paramForIsPosTest ()
    {
        return new Object[][]{
                {"525222222222555", true},
                {"6545323121444000", true},
                {"-5522365411225555", false},
                new Object[]{"-888800000000", false},
        };
    }

    @Test(dataProvider = "DataProviderForIsPosTest")
    public void isPositiveTest (String a, boolean result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.isPositive(FormatHelper.convertStringLong(a)), result);
        softAssert.assertAll();
    }

    @Test()
    public void isPositiveZeroTest ()
    {
        if(!calculator.isPositive(0L)) {
            Assert.fail("0L is not a positive and not a negative number");
        }
    }



    @AfterTest
    public void shutDown() {
        LOG.info("IsPositive test is done.");
    }
}
