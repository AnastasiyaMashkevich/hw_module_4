package epam.com.calculator.test.testng;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CosTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(CosTest.class);

    @BeforeTest
    public void setUp() {
        LOG.info("Cos test is working.");
    }

    @DataProvider(name = "DataProviderForCosTest")
    public Object [] [] paramForCosTest ()
    {
        return new Object[][]{
                {"5.25", "0.5120854772418407", true},
                {"-5.25", "0.5120854772418407", true},
                {"0.00", "1.00", true},
                new Object[]{"25.00", "20.00", false},
        };
    }

    @Test(dataProvider = "DataProviderForCosTest")
    public void cosTest (String a, String b, boolean result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.cos(FormatHelper.convertStringDouble(a)) == FormatHelper.convertStringDouble(b),
                result, "There is a bug in the calculator.cos() using sin()");
        softAssert.assertAll();
    }

    @AfterTest
    public void shutDown() {
        LOG.info("Cos test is done.");
    }
}
