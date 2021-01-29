package utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

import utilities.DriverProperties;


/**
 * 
 * @author sarthak
 *
 */
public class Base {

	
	  static WebDriver driver;
	public DriverProperties prop;

	public WebDriver invokeBrowser() throws IOException {

		prop = new DriverProperties();

		System.setProperty(prop.getWebdriver(), prop.getDriverpath());

		if (prop.getBrowser().equals("chrome")) {

			driver = new ChromeDriver();
		}

		else if (prop.getBrowser().equals("firefox")) {

			driver = new FirefoxDriver();
		}

		else {
			driver = new ChromeDriver();

		}

		driver.manage().window().maximize();
		driver.get(prop.getUrl());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	
	public void getScreenshot( String screenshotId) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File DestFile = new File("./screenshots/" + screenshotId + ".jpg");
		// Copy file at destination
		Files.copy(file, DestFile);

		// System.out.println(screenshot);
	}
}
