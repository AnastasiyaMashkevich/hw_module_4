package epam.com.calculator.test.testng;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SumLongTest extends TestngBaseTest {
    private static final Logger LOG = LogManager.getLogger(SumLongTest.class);

    @DataProvider(name = "DataProviderForSumTest")
    public Object [] [] paramForSumTest ()
    {
        return new Object[][]{
                {10000000000L, 2, 10000000002L},
                {-10000000000L, 2, -9999999998L},
                new Object[]{10000000000L, 20000000000L, 30000000000L},
        };
    }

    @DataProvider(name = "DataProviderForNegativeSumTest")
    public Object [] [] paramForNegativeSumTest ()
    {
        return new Object[][]{
                {10000000000L, 12000000000L, 5000000},
                {5001005000L, -155215454546L, 11},
                {-14105558850252L, -55222221054L, 20},
        };
    }

    @Test(dataProvider = "DataProviderForSumTest")
    public void sumTest (long a, long b, long result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculator.sum(a, b), result);
        softAssert.assertAll();
    }

    @Test(dataProvider = "DataProviderForNegativeSumTest")
    public void sumNegatTest (long a, long b, long result)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(calculator.sum(a, b), result);
        softAssert.assertAll();
    }

}
