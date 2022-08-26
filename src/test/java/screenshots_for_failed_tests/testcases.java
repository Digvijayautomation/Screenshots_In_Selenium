package screenshots_for_failed_tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class testcases extends basetest{
	

	@Test(priority=1)
	public static void test01() throws InterruptedException 
	{
	
		
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login_field")).sendKeys("dtikka6@gmail.com");
		driver.findElement(By.id("password")).sendKeys("git121092");
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Issues")).click();
	}
	
	@Test(priority=2)
	public static void test02() throws InterruptedException 
	{
	
		
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login_field")).sendKeys("qeqeqe");
		driver.findElement(By.id("password")).sendKeys("qeqe");
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Issues")).click();
	}
	
	

}
