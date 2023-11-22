package HYrtetsng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchAndQuit {

	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void launch(String browser) {
		
		switch(browser.toLowerCase())
		{
		
		case "chrome":WebDriverManager.chromedriver().setup();
		
					driver=new ChromeDriver();
					break;
		case "edge":WebDriverManager.edgedriver().setup();
		
					driver=new EdgeDriver();
					break;
		
		case "firefox":WebDriverManager.firefoxdriver().setup();
		
						driver=new FirefoxDriver();
						break;
			
		}
	}
	
	@Parameters({"url","userName","password"})
	@Test
	public void testcase1(String url,String userName,String password) {
		
		driver.get(url);
		driver.manage().window().maximize();
WebElement hoverover=	driver.findElement(By.xpath("//span[.='Hello, sign in']"));
		
		Actions a1=new Actions(driver);
		
		a1.moveToElement(hoverover).perform();
		
		driver.findElement(By.xpath("//span[.='Sign in']")).click();
		driver.findElement(By.id("ap_email")).sendKeys(userName);
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("ap_password")).sendKeys(password);
		
		driver.findElement(By.id("signInSubmit")).click();
	}
	
	@Parameters("sleepTime")
	@AfterMethod
	public void quit(long sleepTime) throws Exception {
		
		Thread.sleep(sleepTime);
		driver.quit();
	}
	
}
