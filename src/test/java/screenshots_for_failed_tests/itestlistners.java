package screenshots_for_failed_tests;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class itestlistners extends basetest implements ITestListener{

	public void onTestFailure(ITestResult result) {
		
		try {
			capturescreenshots(result.getMethod().getMethodName()+".jpg");// it will return failed test method name
		} 
		catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	

}
