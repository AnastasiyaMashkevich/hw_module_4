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

public class IsNegativeTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(IsNegativeTest.class);

    @BeforeTest
    public void setUp() {
        LOG.info("IsNegative test is working.");
    }

    @DataProvider(name = "DataProviderForIsNegativeTest")
    public Object [] [] paramForIsNegativeTest ()
    {
        return new Object[][]{
                {"525222222222555", false},
                {"6545323121444000", false},
                {"-5522365411225555", true},
                new Object[]{"-888800000000", true},
        };
    }

    @Test(dataProvider = "DataProviderForIsNegativeTest")
    public void isNegativeTest (String a, boolean result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.isNegative(FormatHelper.convertStringLong(a)), result);
        softAssert.assertAll();
    }

    @AfterTest
    public void shutDown() {
        LOG.info("IsNegative test is done.");
    }
}
