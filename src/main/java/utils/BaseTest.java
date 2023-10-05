package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.BasePage;

public class BaseTest {
	
	public static WebDriver driver;
	public BasePage app;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.get("https://keybooks.ro/");
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		app = new BasePage();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000); //bad practice
		//driver.close();
		driver.quit();
	}
}
