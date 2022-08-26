import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class taking_screenshot_using_BASE64_method {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.linkText("Sign in")).isEnabled();
		driver.findElement(By.linkText("Sign in")).click();
		
		
		

		TakesScreenshot screen=(TakesScreenshot)driver; // Casting Takescreesnshot to driver
		String Base64screenshot=screen.getScreenshotAs(OutputType.BASE64); // it will store the screenshot in String
		
		byte[] bytearray=Base64.getDecoder().decode(Base64screenshot);// converting base64 to byte array
		FileOutputStream fos=new FileOutputStream("./Screenshots/base64.jpeg"); 
		fos.write(bytearray); // Writing bytearray into fileoutputstream
		fos.close(); 
		
		
		
		driver.quit();
	}

}
