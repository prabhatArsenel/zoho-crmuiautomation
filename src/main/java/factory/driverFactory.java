package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.configreader;

public class driverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    configreader config = new configreader();

    public WebDriver initDriver() {

        String browser = config.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver",
                    "C:\\Program Files\\chromdriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

            // ✅ ADD THIS BLOCK (only change)
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-blink-features=AutomationControlled");

            // ⭐ MOST IMPORTANT FIX
            options.addArguments("--user-data-dir=C:\\temp\\chrome-profile");

            // Optional for Jenkins
            options.addArguments("--headless=new");

            driver.set(new ChromeDriver(options));  // 👈 only this line changed
        }

        getDriver().manage().window().maximize();

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}