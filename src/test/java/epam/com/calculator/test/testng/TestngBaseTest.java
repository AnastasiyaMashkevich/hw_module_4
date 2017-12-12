package epam.com.calculator.test.testng;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestngBaseTest {
	protected Calculator calculator;
	private static final Logger LOG = LogManager.getLogger(TestngBaseTest.class);
	//this static block needs to configure logger
    static {
        BasicConfigurator.configure();
    }

	@BeforeMethod(alwaysRun = true)
	public void beforeTest() {
        LOG.info("Calculator object initialization is starting. ");
        calculator = new Calculator();
	}

	@BeforeGroups
    public void beforeGroup() {
        LOG.info("Before group is working.");
    }

	@AfterMethod
	public void shutDown() {
		LOG.info("Cos test is done.");
	}

    @AfterGroups
    public void afterGroup() {
        LOG.info("After group is working.");
    }

}
