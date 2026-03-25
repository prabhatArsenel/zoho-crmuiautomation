package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Waitutils;

public class basepage {

    public WebDriver driver;
    public Waitutils wait;
    public JavascriptExecutor js;

    // Constructor
    public basepage(WebDriver driver) {
        this.driver = driver;
        wait = new Waitutils(driver);
        js = (JavascriptExecutor) driver; // Initialize JS executor
    }

    /**
     * Scrolls to the bottom of the page
     */
    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    /**
     * Scrolls to the top of the page
     */
    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    /**
     * Scrolls to a specific WebElement
     * @param element - the WebElement to scroll into view
     */
    public void scrollToElement(WebElement element) {
        wait.waitForElementVisible(element); // Optional: wait for element
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Scrolls by a specific number of pixels
     * @param x - horizontal pixels
     * @param y - vertical pixels
     */
    public void scrollByPixels(int x, int y) {
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    /**
     * Scrolls to the center of a specific element
     * Useful if sticky headers cover the top
     * @param element - WebElement to scroll to
     */
    public void scrollToElementCenter(WebElement element) {
        wait.waitForElementVisible(element);
        js.executeScript(
            "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
            + "var elementTop = arguments[0].getBoundingClientRect().top;"
            + "window.scrollBy(0, elementTop - (viewPortHeight / 2));", element);
    }
}