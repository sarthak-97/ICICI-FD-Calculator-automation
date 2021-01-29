package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author sarthak
 *
 */
public class FixedDepositCalculator {
	
	public WebDriver driver;
	
	public FixedDepositCalculator(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(tagName="h1")
	private WebElement pageValidator;
	
	@FindBy(xpath="//*[@id=\"paymframe\"]")
	private WebElement iframe;
	
	@FindBy(xpath="//*[@id=\"ddlTypeOfFixedDeposit\"]")
	private WebElement fixedDepositType;

	@FindBy(xpath="//input[@id='loanAmount']")
	private WebElement loan_amnt;
	
	@FindBy(xpath="//span[@id='spnMaturityValue']")
	private WebElement maturity_val;
	

	
	@FindBy(css="#FixedDepositForm > div > div > div.col.notes > div.divbottom > div:nth-child(3) > div.col.gu5.outAlignLeft > h3")
	private WebElement maturity_val_verify;
	
	@FindBy(xpath="//span[@id='spnAIAmount']")
	private WebElement agg_intrest_value;
	
	@FindBy(id="idDays")
	private WebElement day_radio;

	@FindBy(id="tenureDay")
	private WebElement tennure_days;
	
	@FindBy(xpath="//*[@id=\"main\"]/div[1]/div[2]/a")
	private WebElement logo;
	
	
	
	public WebElement getPageValidator() {
		return pageValidator;
	}

	public Select getFixedDepositType() {
		
		Select fdDropdown= new Select(fixedDepositType);
		return fdDropdown;
	}

	public WebElement getIframe() {
		return iframe;
	}

	public WebElement getLoan_amnt() {
		return loan_amnt;
	}

	public WebElement getMaturity_val() {
		return maturity_val;
	}

	public WebElement getMaturity_val_verify() {
		return maturity_val_verify;
	}

	public WebElement getAgg_intrest_value() {
		return agg_intrest_value;
	}

	public WebElement getDay() {
		return day_radio;
	}

	public WebElement getTennure() {
		return tennure_days;
	}

	public WebElement getLogo() {
		return logo;
	}
	
	
	

}
