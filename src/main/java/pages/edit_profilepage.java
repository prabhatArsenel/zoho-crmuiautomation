package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.basepage;

public class edit_profilepage extends basepage {

    public edit_profilepage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[contains(@class,'zohoapps')]")
    WebElement presentationIcon;

    @FindBy(id="editprofile")
    WebElement edit;

    @FindBy(id="profile_Lname_edit")
    WebElement lastname;

    @FindBy(xpath="//span[text()='Save']")
    WebElement savebu;

    public void click_edit() {
    	wait.waitForElementVisible(edit);
        wait.waitForElementClickable(edit);
        edit.click();
    }

    public void Enter_lastname(String last) {
    	wait.waitForElementVisible(lastname);
        wait.waitForElementVisible(lastname);
        lastname.clear();
        lastname.sendKeys(last);
    }

    public void save_profile() {
    	wait.waitForElementVisible(savebu);
        wait.waitForElementClickable(savebu);
        savebu.click();
    }
}