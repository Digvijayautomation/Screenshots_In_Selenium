package screenshots;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class taking_screenshot_using_FILE_method {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.linkText("Sign in")).isEnabled();
		driver.findElement(By.linkText("Sign in")).click();
		
		
		

		TakesScreenshot screen=(TakesScreenshot)driver; // Casting Takescreesnshot to driver
		File captured_file=screen.getScreenshotAs(OutputType.FILE);// Using OutputType.FILE, it will store the 
		FileUtils.copyFile(captured_file, new File("./Screenshots/file.png")); // SOURCE Will be caupted file and designation will be Folder where to store the screenshots
		driver.quit();
		
		
		

	}

}
