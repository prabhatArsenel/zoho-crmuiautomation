package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.basepage;
public class logoutpage extends basepage {

	public  logoutpage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="headder_thumb_pic")
	WebElement profileicon;
	@FindBy(xpath="//div[contains(text(),\\\" Sign Out \\\")]")
	WebElement signout;
	
	
	public void profileicon() {
		wait.waitForElementVisible(profileicon);
		wait.waitForElementClickable(profileicon);
		scrollToElement(profileicon);
		profileicon.click();
	}
	public void logout() {
		wait.waitForElementVisible(signout);
		wait.waitForElementClickable(signout);
		scrollToElement(signout);
		signout.click();
	}
}
