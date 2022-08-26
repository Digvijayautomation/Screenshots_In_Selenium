package screenshots_for_failed_tests;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
	
	static WebDriver driver;
	static String ScreenshotSubfoldername;
	
	@BeforeMethod
	public static void setUp() {
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/");
	}
	
	@AfterMethod
     public void teardown() {
		
    	 driver.quit();
	    }
	
	
	public void capturescreenshots(String filename) throws IOException
	{
		//code for creating subfolders date-time wise
		
		if(ScreenshotSubfoldername ==null)
		{
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
	   ScreenshotSubfoldername = myDateObj.format(myFormatObj);
	   System.out.println(ScreenshotSubfoldername);
	    
		}
	    //ends here

		
		// screenshot capture code
		TakesScreenshot screen=(TakesScreenshot)driver; 
		File captured_file=screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(captured_file, new File("./Screenshots_for_failed_test/" + ScreenshotSubfoldername +"/"+filename));
		
		System.out.println("Screenshot saved Successfully");
		
	}

}
