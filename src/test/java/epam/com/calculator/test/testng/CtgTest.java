package epam.com.calculator.test.testng;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CtgTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(CtgTest.class);

    @BeforeTest
    public void setUp() {
        LOG.info("Ctg test is working.");
    }

    @DataProvider(name = "DataProviderForCtgTest")
    public Object [] [] paramForCtgtTest () {
        return new Object[][]{
                {"0.25", "0.24", true},
                {"-0.25", "-0.24", true},
                {"125.00", "1.00", true},
                new Object[]{"200.00", "20.00", false},
        };
    }

    @Test(dataProvider = "DataProviderForCtgTest", groups = {"Debug"})
    public void ctgTest (String a, String b, boolean result) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(FormatHelper.round(calculator.ctg(FormatHelper.convertStringDouble(a))) == FormatHelper.convertStringDouble(b),
                result, "The operation of Ctg is not correct");
        softAssert.assertAll();
    }

    @AfterTest
    public void shutDown() {
        LOG.info("Ctg test is done.");
    }
}
