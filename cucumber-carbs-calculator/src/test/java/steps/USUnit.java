package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import support.DriverFactory;

public class USUnit {

    private WebDriver driver;

    @And("I click on US units tab")
    public void clickUSUnitsTab() {
        driver = DriverFactory.driver;
        driver.findElement(By.xpath("//a[contains(text(), 'US Units')]")).click();
    }

    @And("I enter height as {int} feet and {int} inches")
    public void enterHeightUS(int feet, int inches) {
        driver = DriverFactory.driver;
        WebElement feetBox = driver.findElement(By.name("cheightfeet"));
        feetBox.clear();
        feetBox.sendKeys(String.valueOf(feet));
        
        WebElement inchesBox = driver.findElement(By.name("cheightinch"));
        inchesBox.clear();
        inchesBox.sendKeys(String.valueOf(inches));
    }

    @And("I enter weight as {int} pound")
    public void enterWeightUS(int weight) {
        driver = DriverFactory.driver;
        WebElement weightBox = driver.findElement(By.name("cpound"));
        weightBox.clear();
        weightBox.sendKeys(String.valueOf(weight));
    }
}
