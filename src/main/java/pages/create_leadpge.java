package pages;

import java.time.Duration;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.basepage;

public class create_leadpge extends basepage {

	public create_leadpge(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	//By presentation_icon=By.xpath("//div[@class='zohoapps__candybox__mJBpQ']");
	@FindBy(xpath="//div[@class='zohoapps__candybox__mJBpQ']")
	WebElement presentation_icon;
	
	@FindBy(id="//input[@class='zmtext__box__awdq0g']")
	WebElement search_icon;
	
	@FindBy(xpath="//Span[contains(text(),'CRM')])[2]")
	WebElement CRM;
	
	@FindBy(id="searchInput")
	WebElement search_sales;
	//By sales=By.xpath("//lyte-text[@class=\"crm-base-font-size crm-font-semibold w100_per\"][1]");(As i am able to search the leads directly so putting this under comment)
	@FindBy(xpath="//lyte-text[contains(text(),'Leads')]")
	WebElement sales;
	//By lead=By.xpath("//lyte-text[contains(text(),'Leads')]");
	@FindBy(xpath="//button[contains(text(),'Create Lead')]")
	WebElement lead;
	//By  create_lead=By.xpath("//button[contains(text(),'Create Lead')]");
	@FindBy(xpath="//button[contains(text(),'Create Lead')]")
	WebElement create_lead;
	//By company=By.id("inputId");
	@FindBy(id="inputId")
	WebElement company;
	//By last_name=By.id("Crm_Leads_LASTNAME_LInput");
	@FindBy(id="Crm_Leads_LASTNAME_LInput")
	WebElement Last_name;
	//By save=By.id("crm_create_savebutnLeads");
	@FindBy(id="crm_create_savebutnLeads")
	WebElement save;
	
	
	//methods for this class
	public void icon_click() {
		//System.out.println("Hello_prabhat");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait.waitForElementClickable(presentation_icon);
		//System.out.println("Hello_prabhat");
		presentation_icon.click();
	}
	//public void click_searchiconcrm(String text) {
		
		//wait.waitForElementClickable(search_icon);
		//search_icon.click();
		//search_icon.sendKeys(text);
		
	//}
	public void click_crm() {

	    // Store parent window
	    String parentWindow = driver.getWindowHandle();

	    // Click CRM icon
	    wait.waitForElementClickable(CRM);
	    CRM.click();

	    // Wait until new window appears
	    wait.waitForNumberOfWindowsToBe(2);

	    // Get all windows
	    Set<String> windows = driver.getWindowHandles();

	    // Switch to new window
	    for (String window : windows) {

	        if (!window.equals(parentWindow)) {

	            driver.switchTo().window(window);
	            break;
	        }
	    }
	}
	
	public void Search_leads(String text) {
		wait.waitForElementClickable(search_sales);
		search_sales.click();
		search_sales.sendKeys(text);
		wait.waitForElementClickable(lead);
		lead.click();
	}
	public void create_lead(String compny,String last_nam) {
		wait.waitForElementClickable(create_lead);
		create_lead.click();
		wait.waitForElementVisible(company);
		company.sendKeys(compny);
		wait.waitForElementVisible(Last_name);
		Last_name.sendKeys("last_name");
		wait.waitForElementClickable(save);
		save.click();
	}
	

}
