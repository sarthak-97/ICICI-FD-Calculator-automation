package scripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import methodlib.MethodLibrary;
import pageObjects.FixedDepositCalculator;
import utilities.Base;

/**
 * 
 * @author sarthak
 *
 */
public class ICICIFdCalcTest {

	static WebDriver driver;
	public static Logger log = LogManager.getLogger(ICICIFdCalcTest.class.getName());

	@BeforeClass
	public void beforeClass() throws IOException {

		log.info("driver intialised");
		Base base = new Base();
		driver = base.invokeBrowser();
	}

	@Test
	public void testCalc() throws InterruptedException, IOException {

		MethodLibrary lib = new MethodLibrary(driver,log);
	
		
		lib.pageValidate();
		lib.switchToIframe();
	
	
		lib.enterDetails();
		lib.switchToNormal();
		lib.clickLogo();
		

		
	

	}

	@AfterClass
	public void afterClass() {

		driver.close();
		driver = null;
		log.info("driver closed");
	}

}
