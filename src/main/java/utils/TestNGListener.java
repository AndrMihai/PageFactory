package utils;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

public class TestNGListener implements IResultListener{

	@Override
	public void onTestStart(ITestResult result) {
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("+++ Started test case:" + result.getMethod().getMethodName() );
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("+++ Start time :" + timestamp);
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("+++ Passed test case:" + result.getMethod().getMethodName() );
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("+++ End time :" + timestamp);
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Log.error("+++++++++++++++++++++++++++++++++++++++++++++++");
		Log.error("+++ Failed test case:" + result.getMethod().getMethodName() );
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.error("+++ Fail time :" + timestamp);
		Log.error(result.getThrowable());
		Log.error("+++++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Log.info("++++ Skiped test case :" + result.getMethod().getMethodName() + " +++++");
	}


}
