package screenshots;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class taking_screenshot_of_full_page {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://locust.io/");
	
		
		// we have to add special dependency Ashot for taking full page screenshot
		Screenshot screen=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver); // 1000 is speed of scrolling the page to take full page screenshot
		
		//ImageIo class will take three parameters, captured image, extension, storage path
		ImageIO.write(screen.getImage(), "png", new File("./Screenshots/fullpage.png"));
	
		driver.close();
	}

}
