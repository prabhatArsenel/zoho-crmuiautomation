package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import factory.driverFactory;
import utils.configreader;
import pages.loginpage;
import pages.logoutpage;

public class basetest {

    protected WebDriver driver;
    driverFactory df = new driverFactory();
    configreader cr = new configreader();

    @BeforeClass
    public void setup() {
        df.initDriver();                        // initialize driver
        driver = driverFactory.getDriver();     // get driver for current thread
        driver.get(cr.getUrl());
    }

    @BeforeMethod
    public void login() {
        try {
            loginpage login = new loginpage(driver);
            login.enterUsername("hiprabhat1997@gmail.com");
            login.Click_nextbutton();
            login.Eyeicon_click();
            login.enterPassword("Hibatman@2910");
            login.clickLogin();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }

    @AfterMethod
    public void logout() {
        try {
            logoutpage home = new logoutpage(driver);
            home.profileicon();
            home.logout();
        } catch (Exception e) {
            System.out.println("Logout skipped: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driverFactory.getDriver() != null) {
            driverFactory.getDriver().quit();
        }
    }
}