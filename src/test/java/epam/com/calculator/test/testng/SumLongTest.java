package epam.com.calculator.test.testng;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SumLongTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(SumLongTest.class);

    @DataProvider(name = "DataProviderForSumTest")
    public Object [] [] paramForSumTest () {
        return new Object[][]{
                {100, 2, 102},
                {-100, 2, -98},
                new Object[]{100, 200, 300},
        };
    }

    @DataProvider(name = "DataProviderForNegativeSumTest")
    public Object [] [] paramForNegativeSumTest () {
        return new Object[][]{
                {100, 12, 50},
                {50, -155, 11},
                {-14105, -552, 20},
        };
    }

    @Test(dataProvider = "DataProviderForSumTest", groups = {"Debug"})
    public void sumTest (long a, long b, long result) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.sum(a, b), result, "The operation of addition is not correct");
        softAssert.assertAll();
    }

    @Test(dataProvider = "DataProviderForNegativeSumTest", groups = {"Debug"})
    public void sumNegatTest (long a, long b, long result) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(calculator.sum(a, b), result, "The operation of addition is not correct");
        softAssert.assertAll();
    }

}
