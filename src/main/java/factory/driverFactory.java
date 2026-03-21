package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.configreader;

public class driverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    configreader config = new configreader();

    public WebDriver initDriver() {

        String browser = config.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver",
                    "C:\\Program Files\\chromdriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

            driver.set(new ChromeDriver());
        }

        getDriver().manage().window().maximize();

        return getDriver();
    }

    public static WebDriver getDriver() {

        return driver.get();
    }
}