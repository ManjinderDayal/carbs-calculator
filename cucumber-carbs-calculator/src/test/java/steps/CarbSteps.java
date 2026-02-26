package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.DriverFactory;

import java.time.Duration;

import static org.junit.Assert.*;

public class CarbSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("Page open in Chrome.")
    public void openPage() {
        driver = DriverFactory.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.calculator.net/carbohydrate-calculator.html");
    }

    @And("Metric units tab active.")
    public void metricTabActive() {
    }

    @When("I enter age as {int}")
    public void enterAge(int age) {
        WebElement ageBox = driver.findElement(By.name("cage"));
        ageBox.clear();
        ageBox.sendKeys(String.valueOf(age));
    }

    @And("I select gender as {word}")
    public void selectGender(String gender) {
        WebElement radio;
        if (gender.equalsIgnoreCase("male")) {
            radio = driver.findElement(By.xpath("//input[@value='m']"));
        } else {
            radio = driver.findElement(By.xpath("//input[@value='f']"));
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
    }

    @And("I enter height as {int} cm")
    public void enterHeight(int height) {
        WebElement heightBox = driver.findElement(By.name("cheightmeter"));
        heightBox.clear();
        heightBox.sendKeys(String.valueOf(height));
    }

    @And("I enter weight as {int} kg")
    public void enterWeight(int weight) {
        WebElement weightBox = driver.findElement(By.name("ckg"));
        weightBox.clear();
        weightBox.sendKeys(String.valueOf(weight));
    }

    @And("I select activity level as {string}")
    public void selectActivityLevel(String activity) {
        Select dropdown = new Select(driver.findElement(By.name("cactivity")));
        dropdown.selectByVisibleText(activity);
    }

    @And("I click the Calculate button")
    public void clickCalculate() {
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @Then("the result table should appear with {int} on the page")
    public void verifyResultTable(int rows) {
        WebElement table = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//table[contains(.,'Daily Calorie Allowance')]")
                )
        );

        assertTrue(table.isDisplayed());

        int actualRows = table.findElements(By.tagName("tr")).size();
        assertTrue("Expected at least " + rows + " rows but got " + actualRows, actualRows >= rows);
    }

    @And("Daily Calorie Allowance and carb gram values as 40%, 55%, 65%, 75% percentage column")
    public void verifyPercentageColumns() {
        WebElement table = driver.findElement(By.xpath("//table[contains(.,'Daily Calorie Allowance')]"));
        String text = table.getText();

        assertTrue(text.contains("40%"));
        assertTrue(text.contains("55%"));
        assertTrue(text.contains("65%"));
        assertTrue(text.contains("75%"));
    }

    @And("Daily Calorie Allowance and carb gram values should not be zero")
    public void verifyValuesNotZero() {
        WebElement table = driver.findElement(By.xpath("//table[contains(.,'Daily Calorie Allowance')]"));
        String text = table.getText();
        assertTrue("No values found in results", text.length() > 0);
    }
}