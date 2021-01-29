package methodlib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import pageObjects.FixedDepositCalculator;
import utilities.Base;
import utilities.ReadFromExcel;
import utilities.WritetoExcel;

/**
 * Method library for the icici application
 * 
 * @author sarthak
 *
 *
 */
public class MethodLibrary extends Base {

	public WebDriver driver;
	private Logger log;
	FixedDepositCalculator fdCalculator =null;
	static Map<String,String> inputData=null;
	
	public MethodLibrary(WebDriver driver , Logger log) throws IOException {
		
		this.driver=driver;
		this.log=log;
		fdCalculator= new FixedDepositCalculator(driver);
		inputData	= ReadFromExcel.getExcelData("testData.xlsx");
	}
	



	
	
	public void pageValidate() throws IOException {

	
	Assert.assertTrue(fdCalculator.getPageValidator().getText().equals(inputData.get("pageValidator")),"page not found");
	
	getScreenshot("FD_Page");
	}
	
	public void switchToIframe() {
		

		driver.switchTo().frame(fdCalculator.getIframe());
		log.info("Switiching to iframe");
	}
	
	
	public void enterDetails() throws IOException, InterruptedException {
		
		//***************Reading data from Excel*****************
		
		System.out.println(inputData.get("typeFD"));
		
		//"Quarterly Payout"
		fdCalculator.getFixedDepositType().selectByVisibleText(inputData.get("typeFD"));
		
		log.info("Selecting quaterly payout");

		log.info("clearing loan amount");
		fdCalculator.getLoan_amnt().clear();
		
		fdCalculator.getLoan_amnt().sendKeys(inputData.get("loanAmnt"));
		log.info("adding 60000 as loan amount");
		getScreenshot("loanAmount");
		
		new Actions(driver).sendKeys(Keys.TAB).build().perform();
		log.info("pressing tab key");
		fdCalculator.getDay().click();
	
		log.info("Selecting tennure type as days");
		fdCalculator.getTennure().clear();
		
		fdCalculator.getTennure().sendKeys(inputData.get("tennure"));
		log.info("tennure days as 1000");
		getScreenshot("tennure");
		
		new Actions(driver).sendKeys(Keys.TAB).build().perform();
		log.info("pressing tab key");
	
		String maturity_val = fdCalculator.getMaturity_val().getText();
		String aggregate = fdCalculator.getAgg_intrest_value().getText();
		log.info("The maturity Value is : " + maturity_val);
		log.info("The aggregate intrest Value is : " + aggregate);
		
		getScreenshot("result");
		Hashtable<String,String> outputData= new Hashtable<String,String>();
		
		outputData.put("maturity value",maturity_val);
		outputData.put("aggregate value",aggregate);
		
		WritetoExcel.writeToExcel(outputData,"Results");

		System.out.println("The maturity Value is : " + maturity_val);
		System.out.println("The aggregate intrest Value is : " + aggregate);
		

	}
	
	public void switchToNormal() throws InterruptedException {
		
		driver.switchTo().defaultContent();
		log.info("driver switch to normal mode");
		

	}
	
	public void clickLogo() throws InterruptedException, IOException {
		
		
		
		new Actions(driver).sendKeys(Keys.PAGE_UP).build().perform();
		fdCalculator.getLogo().click();

		log.info("icici logo click ");
		log.info(driver.getTitle());
		getScreenshot("HomePage");
		
	}
	
	
}
