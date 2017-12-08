package epam.com.calculator.runner;

import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

/**
 * Created by anastasiya_mashkevic on 12/8/17.
 */
public class Runner {
	public static void main (String[] args) {
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("./src/test/resources/testng.xml");
		testng.setTestSuites(suites);
		testng.run();

		//    ----- another variant ----
		//    TestNG testng = new TestNG();
		//    testng.setTestClasses(new Class[] { GoogleSearchTest.class });
		//    testng.run();

	}
}
