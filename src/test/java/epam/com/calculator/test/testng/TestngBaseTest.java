package epam.com.calculator.test.testng;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestngBaseTest {
	public Calculator calculator;
	private static final Logger LOG = LogManager.getLogger(TestngBaseTest.class);
    static {
        BasicConfigurator.configure();
    }

	@BeforeTest
	public void beforeTest() {
        LOG.info("Before test is working.");
        calculator = new Calculator();
	}

	@BeforeGroups
    public void beforeGroup() {
        LOG.info("Before group is working.");
    }

    @AfterGroups
    public void afterGroup() {
        LOG.info("After group is working.");
    }

	@AfterTest
    public void afterTest() {
	    LOG.info("After test is working.");
    }

}
