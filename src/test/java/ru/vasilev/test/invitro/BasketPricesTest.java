package ru.vasilev.test.invitro;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketPricesTest {

    private ChromeDriver driver;

    @Test
    public void basketPricesTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver/chromedriver.exe");

        driver = new ChromeDriver();
        JavascriptExecutor jsExecutor = driver;
        driver.get("https://www.invitro.ru/analizes/for-doctors/");

        final By locatorItemPrice = By.className("result-item__price");
        final By locatorLinkBasket = By.xpath("//div[@class='header-cart__icon']/a");
        final By locatorButtonAddToBasket = By.xpath("//div[@class='btn-icon add_basket']");
        final By locatorPriceInBasket =
                By.xpath("//ul[@class='basket-list main_basketlist']/li[1]/div[@class='row']/div[@class='basket-list__item-second']/span[@class='basket-list__item-price']");

        final WebDriverWait wait = new WebDriverWait(driver, 10);

        final String currentPriceStr = driver.findElement(locatorItemPrice).getText();
        int expectedPrice = Integer.parseInt(currentPriceStr.split(" ")[0]);

        final WebElement buttonAddToBasket = driver.findElement(locatorButtonAddToBasket);

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", buttonAddToBasket);

        Actions build = new Actions(driver);
        build.moveToElement(buttonAddToBasket).moveByOffset(5, 5).click().build().perform();
        wait.until(ExpectedConditions.textToBePresentInElement(buttonAddToBasket, "Добавлено"));

        final WebElement linkBasket = driver.findElement(locatorLinkBasket);
        linkBasket.click();

        final WebElement priceInBasket = wait.until(ExpectedConditions.presenceOfElementLocated(locatorPriceInBasket));
        final int actualPrice = Integer.parseInt(priceInBasket.getText().split(" ")[0]);

        assertEquals(expectedPrice, actualPrice);
        driver.quit();
    }
}
