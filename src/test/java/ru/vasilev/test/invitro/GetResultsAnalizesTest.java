package ru.vasilev.test.invitro;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetResultsAnalizesTest {

    private ChromeDriver driver;

    @Test
    public void getResultsAnalizesTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.invitro.ru/radiology/");
        JavascriptExecutor jsExecutor = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        final By locatorButtonGetResults = By.xpath("//div[@id='bvi-block']/header/div[@class='header-bottom']/button[@class='header-nav__get-result popupBtn']");
        final By locatorInz = By.id("inz");
        final By locatorBorn = By.id("born");
        final By locatorSurname = By.id("surname");
        final By locatorGetAnalisisBtn = By.id("getAnalisisBtn");
        final By locatorResultQuantErrorNotFound = By.xpath("//div[@class='attention__inner']/div[@class='attention__content']");
        final By locatorResultQuantError = By.id("resultQuantError");

        wait.until(ExpectedConditions.presenceOfElementLocated(locatorButtonGetResults));

        jsExecutor.executeScript("$( document ).ready(function() {$.magnificPopup.open({" +
                "items: {" +
                "src: '#popupResult'}" +
                "});});");


        wait.until(ExpectedConditions.elementToBeClickable(locatorInz));
        final WebElement getAnalisisBtn = driver.findElement(locatorGetAnalisisBtn);
        getAnalisisBtn.click();


        wait.until(ExpectedConditions.elementToBeClickable(locatorInz));
        WebElement resultQuantError = driver.findElement(locatorResultQuantError);
        assertEquals("Поля Код ИНЗ, Дата рождения, Фамилия обязательны для заполнения.", resultQuantError.getText());

        final String redValue = "rgba(255, 0, 0, 1)";
        wait.until(ExpectedConditions.attributeToBe(locatorInz, "color", redValue));
        wait.until(ExpectedConditions.attributeToBe(locatorBorn, "color", redValue));
        wait.until(ExpectedConditions.attributeToBe(locatorSurname, "color", redValue));

        final WebElement inz = driver.findElement(locatorInz);
        final WebElement born = driver.findElement(locatorBorn);
        final WebElement surname = driver.findElement(locatorSurname);


        inz.sendKeys("231231231");

        born.sendKeys("12012000");

        surname.sendKeys("Тест");

        getAnalisisBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(locatorResultQuantErrorNotFound));
        resultQuantError = driver.findElement(locatorResultQuantErrorNotFound);
        assertEquals("Ваши результаты анализов не найдены. Пожалуйста, измените параметры и повторите поиск", resultQuantError.getText());
        driver.quit();
    }
}
