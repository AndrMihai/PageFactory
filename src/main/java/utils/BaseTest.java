package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.google.common.io.Files;

import pages.BasePage;

public class BaseTest extends Driver {
	
	public WebDriver driver;
	public BasePage app;
	@Parameters({"appURL", "browser"})
	@BeforeClass(alwaysRun = true)
	public void setup(String orice, String browser) {
		//driver = new ChromeDriver();
		driver = initDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.get(orice); //sau cu URL keyfood.ro, aici parsam parametrul orice
		//driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		app = new BasePage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000); //bad practice
		//driver.close();
		driver.quit();
	}
	
	@AfterMethod
	public void recordFailure(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot poza = (TakesScreenshot) driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			try {
				Files.copy(picture, new File("poze/"+result.getName()+" - "+timestamp+ ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
