package ru.vasilev.test.invitro;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickingMenu {

    private ChromeDriver driver;

    @Test
    public void clickAllMenuItemsTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.invitro.ru/radiology/");
        JavascriptExecutor jsExecutor = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        final By locator = By.className("side-bar-second__link");
        final By locatorActiveItem = By.className("side-bar__items--active");
        final By locatorSubItems = By.className("side-bar-third__link");
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        int numberOfElementsFound = getNumberOfElementsFound(locator);

        for (int pos = 0; pos < numberOfElementsFound; pos++) {
            wait.until(ExpectedConditions.elementToBeClickable(locator));

            final WebElement elementClickable = getElementWithIndex(locator, pos);
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", elementClickable);
            elementClickable.click();

            wait.until(ExpectedConditions.elementToBeClickable(locatorActiveItem));

            int numberOfSubElementsFound = getNumberOfElementsFound(locatorActiveItem, locatorSubItems);
            for (int subPos = 0; subPos < numberOfSubElementsFound; subPos++) {
                wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locatorSubItems, 0));
                final WebElement subElementClickable = getElementWithIndex(locatorActiveItem, locatorSubItems, subPos);
                jsExecutor.executeScript("arguments[0].scrollIntoView(true)", subElementClickable);

                wait.until(ExpectedConditions.visibilityOf(subElementClickable));
                subElementClickable.click();
            }
        }
        driver.quit();
    }

    private WebElement getElementWithIndex(By locatorActiveItem, By locatorSubItems, int index) {
        return driver.findElement(locatorActiveItem).findElements(locatorSubItems).get(index);
    }

    private int getNumberOfElementsFound(By locatorActiveItem, By locatorSubItems) {
        return driver.findElement(locatorActiveItem).findElements(locatorSubItems).size();
    }

    public int getNumberOfElementsFound(By by) {
        return driver.findElements(by).size();
    }

    public WebElement getElementWithIndex(By by, int index) {
        return driver.findElements(by).get(index);
    }
}
