package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// ❌ REMOVE THIS
// import io.github.bonigarcia.wdm.WebDriverManager;

import utils.configreader;

public class driverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    configreader config = new configreader();

    public WebDriver initDriver() {

        String browser = config.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {

            // ✅ ADD THIS (manual driver path)
            System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-blink-features=AutomationControlled");

            // ✅ Keep your thread-safe profile logic
            String threadName = Thread.currentThread().getName().replaceAll("[^a-zA-Z0-9]", "");
            String profilePath = "C:\\temp\\chrome-profile-" + threadName;

            options.addArguments("--user-data-dir=" + profilePath);

            driver.set(new ChromeDriver(options));
        }

        getDriver().manage().window().maximize();

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}