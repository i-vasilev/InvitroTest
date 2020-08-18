package ru.vasilev.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTablesTests {

    private WebDriver driver;

    @Test
    public void implicitlyWaitTest() {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        driver.get("https://datatables.net/examples/server_side/row_details.html");

        WebElement tableExamples = driver.findElement(By.id("example"));

        List<WebElement> tableRows = tableExamples.findElements(By.cssSelector("tbody > tr[role='row']"));

        assertEquals(tableRows.size(), 10);

        Select select = new Select(driver.findElement(By.name("example_length")));
        select.selectByValue(String.valueOf(25));

        tableRows =new WebDriverWait(driver, 10, 1000)
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#example tbody > tr[role='row']"), 25));
        assertEquals(tableRows.size(), 25);

        driver.quit();
    }
}
