package epam.com.calculator.test.testng;

import epam.com.calculator.test.support.FormatHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TgTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(TgTest.class);

    @BeforeTest
    public void setUp() {
        LOG.info("Tg test is working.");
    }

    @DataProvider(name = "DataProviderForTgTest")
    public Object [] [] paramForTgTest ()
    {
        return new Object[][]{
                {"5.00", "1.00", true},
                {"-5.00", "1.00", true},
                {"12.00", "54.00", false},
                new Object[]{"20.00", "22.00", false},
        };
    }

    @Test(dataProvider = "DataProviderForTgTest", groups = {"Debug"})
    public void tgTest (String a, String b, boolean result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.tg(FormatHelper.convertStringDouble(a)) == FormatHelper.convertStringDouble(b),
                result, "The operation of Tg is not correct");
        softAssert.assertAll();
    }

    @AfterTest
    public void shutDown() {
        LOG.info("Tg test is done.");
    }
}
