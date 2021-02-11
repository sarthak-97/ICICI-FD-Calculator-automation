package scripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.icici.models.UserRepo;
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
 * @author sarthak-pc
 *
 */
public class DBTest {



	@Test
	public void testCalc() throws InterruptedException, IOException {

		UserRepo rep= new UserRepo();
		
		rep.setData();
		System.out.println("done");
		
		
	

	}


}
