package base;

import org.openqa.selenium.WebDriver;
import utils.Waitutils;

public class basepage {

    public WebDriver driver;
    public Waitutils wait;

    public basepage(WebDriver driver) {
        this.driver = driver;
        wait = new Waitutils(driver);
    }
}