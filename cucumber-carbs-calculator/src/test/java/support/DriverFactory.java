package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver driver;

    public static void initDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");   // better than --headless
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
