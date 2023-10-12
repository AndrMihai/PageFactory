package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
	
	//daca nu vrem sa rulam in paralel
	//public WebDriver driver;
	//daca vrem sa rulam in paralel
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public WebDriver initDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver(getChromeOptions()));
			@SuppressWarnings("deprecation")
			long chromeId = Thread.currentThread().getId();
			Log.info(browser + "---> Thread id: " + chromeId);
			return driver.get();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver(getFirefoxOptions()));
			@SuppressWarnings("deprecation")
			long firefoxId = Thread.currentThread().getId();
			Log.info(browser + "---> Thread id: " + firefoxId);
			return driver.get();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			@SuppressWarnings("deprecation")
			long edgeId = Thread.currentThread().getId();
			Log.info(browser + "---> Thread id: " + edgeId);
			return driver.get();
		}
		return driver.get();
		
	}
	public static ChromeOptions getChromeOptions() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		option.addArguments("--window-size=1580, 1280");
		
		return option;
	}
	public static FirefoxOptions getFirefoxOptions() {
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		
		return firefoxOptions;
	}
	public static EdgeOptions getEdgeOptions() {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--headless");
		edgeOptions.addArguments("--window-size=1580, 1280");
		
		return edgeOptions;
	}

}
