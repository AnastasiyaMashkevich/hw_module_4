package epam.com.calculator.runner.listner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;


public class TestListners implements ITestListener {

	private static final Logger log = LogManager.getLogger(TestListners.class);

	static {
		BasicConfigurator.configure();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		log.info("Test  /"+ iTestResult.getMethod().getMethodName()+"/ is start. ");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		log.info(("Test  /"+ iTestResult.getMethod().getMethodName()+"/ is success. "));
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		log.info(("Test  /"+ iTestResult.getMethod().getMethodName()+"/ is fail. "));
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	@Override
	public void onStart(ITestContext iTestContext) {
		log.info("Test started at " + iTestContext.getStartDate());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		log.info("Test finished at " + iTestContext.getEndDate());
	}
}
