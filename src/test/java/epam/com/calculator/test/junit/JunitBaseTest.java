package epam.com.calculator.test.junit;

import com.epam.tat.module4.Calculator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;

public class JunitBaseTest {
	private static final Logger LOG = LogManager.getLogger(JunitBaseTest.class);
	protected Calculator calculator;
	//this static block needs to configure logger
	static {
		BasicConfigurator.configure();
	}

	@Before
	public void beforeMethod() {
		LOG.info("Calculator object initialization is starting. ");
		calculator = new Calculator();
	}
}
