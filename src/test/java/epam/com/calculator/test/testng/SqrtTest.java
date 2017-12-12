package epam.com.calculator.test.testng;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SqrtTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(SqrtTest.class);

    @BeforeTest
    public void setUp() {
        LOG.info("Sqrt test is working.");
    }

    @DataProvider(name = "DataProviderForSqrtTest")
    public Object [] [] paramForSqrtTest ()
    {
        return new Object[][]{
                {"25.00", "5.00", true},
                {"-25.00", "5.00", true},
                {"102.00", "54.00", false},
                new Object[]{"200.00", "20.00", false},
        };
    }

    @Test(dataProvider = "DataProviderForSqrtTest", groups = {"Debug"})
    public void sqrtTest (String a, String b, boolean result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.sqrt(FormatHelper.convertStringDouble(a)) == FormatHelper.convertStringDouble(b),
                result, "Sqrt operation is not correct");
        softAssert.assertAll();
    }

    @AfterTest
    public void shutDown() {
        LOG.info("Sqrt test is done.");
    }
}
