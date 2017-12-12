package epam.com.calculator.test.testng;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SinTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(SinTest.class);

    @BeforeTest
    public void setUp() {
        LOG.info("Sin test is working.");
    }

    @DataProvider(name = "DataProviderForSinTest")
    public Object [] [] paramForSinTest () {
        return new Object[][]{
                {"5.25", "-0.86", true},
                {"-5.25", "0.86", true},
                {"0.00", "0.0", true},
                new Object[]{"25.00", "20.0", false},
        };
    }

    @Test(dataProvider = "DataProviderForSinTest", groups = {"Debug"})
    public void sinTest (String a, String b, boolean result) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(FormatHelper.round(calculator.sin(FormatHelper.convertStringDouble(a))) == FormatHelper.convertStringDouble(b),
                result, "Sin operation is not correct");
        softAssert.assertAll();
    }

    @AfterTest
    public void shutDown() {
        LOG.info("Sin test is done.");
    }
}
