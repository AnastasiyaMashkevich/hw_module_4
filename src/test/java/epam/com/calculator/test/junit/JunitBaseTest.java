package epam.com.calculator.test.junit;

import com.epam.tat.module4.Calculator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class JunitBaseTest {
	private static final Logger LOG = LogManager.getLogger(JunitBaseTest.class);
	static {
		BasicConfigurator.configure();
	}
	protected Calculator calculator = new Calculator();

}
