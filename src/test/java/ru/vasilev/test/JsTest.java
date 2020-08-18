package ru.vasilev.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsTest {
    private ChromeDriver driver;

    @Test
    public void jsTest() {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://yahoo.com");

        JavascriptExecutor jsExecutor = driver;

        WebElement mailLink =
                (WebElement) jsExecutor.executeScript("return document.getElementById('header-logo')");

        mailLink.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
    }
}
