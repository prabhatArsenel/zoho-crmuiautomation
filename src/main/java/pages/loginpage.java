package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.basepage;

public class loginpage extends basepage {

    public loginpage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="login_id")
    WebElement username;

    @FindBy(id="nextbtn")
    WebElement nextbutton;

    @FindBy(xpath="(//span[@class='icon-hide show_hide_password'])[1]")
    WebElement eyeIcon;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="nextbtn")
    WebElement loginBtn;

    public void enterUsername(String user) {
        wait.waitForElementVisible(username);
        username.sendKeys(user);
    }

    public void Click_nextbutton() {
        wait.waitForElementClickable(nextbutton);
        nextbutton.click();
    }

    public void Eyeicon_click() {
        wait.waitForElementClickable(eyeIcon);
        eyeIcon.click();
    }

    public void enterPassword(String pass) {
        wait.waitForElementVisible(password);
        password.sendKeys(pass);
    }

    public void clickLogin() {
        wait.waitForElementClickable(loginBtn);
        loginBtn.click();
    }

   
    }
