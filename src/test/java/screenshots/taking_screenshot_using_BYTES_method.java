package screenshots;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class taking_screenshot_using_BYTES_method {
	
static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.linkText("Sign in")).isEnabled();
		driver.findElement(By.linkText("Sign in")).click();
		
		
		

		TakesScreenshot screen=(TakesScreenshot)driver; // Casting Takescreesnshot to driver
		byte[] Base64screenshot=screen.getScreenshotAs(OutputType.BYTES); // it will store the screenshot in String
		FileOutputStream fos=new FileOutputStream("./Screenshots/byte.jpeg"); 
		fos.write(Base64screenshot); // Writing bytearray into fileoutputstream
		fos.close(); 
		
		
		
		driver.quit();
	}


}
