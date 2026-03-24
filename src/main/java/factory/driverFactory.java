package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;   // ✅ ADD THIS

import utils.configreader;

public class driverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    configreader config = new configreader();

    public WebDriver initDriver() {

        String browser = config.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {

            // ❌ REMOVE THIS (causing version mismatch)
            // System.setProperty("webdriver.chrome.driver",
            //        "C:\\Program Files\\chromdriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

            // ✅ ADD THIS (auto-manages correct driver)
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-blink-features=AutomationControlled");

            // ✅ Unique profile per thread (already correct)
            String threadName = Thread.currentThread().getName().replaceAll("[^a-zA-Z0-9]", "");
            String profilePath = "C:\\temp\\chrome-profile-" + threadName;

            options.addArguments("--user-data-dir=" + profilePath);

            // ❌ Keep headless OFF for Zoho

            driver.set(new ChromeDriver(options));
        }

        getDriver().manage().window().maximize();

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}