package com.example.seleniumtests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SiteTests {

    private static WebDriver driver;
    WebElement element;

    @BeforeClass
    public static void driverSetup() {
        // ChromeDrirver, FireforxDriver, ...
        System.setProperty("webdriver.chrome.driver", "c:\\tmp\\chromedriver.exe");
        driver = new ChromeDriver();
        Dimension dimension = new Dimension(1600,900);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.seleniumframework.com/Practiceform/");
    }

    @Test
    public void TextAreaTest(){


        element = driver.findElement(By.id("vfb-10"));
        element.clear();
        element.sendKeys("Jakiś tam tekst.");
    }

    @Test
    public void TextBoxTest(){

        element = driver.findElement(By.id("vfb-9"));
        element.clear();
        element.sendKeys("Jakiś tam drugi tekst.");
    }

    @Test
    public void CheckboxTest(){
        List<WebElement> AllCheckBoxes = driver.findElements(By.className("vfb-checkbox"));

        AllCheckBoxes.get(0).click();
        AllCheckBoxes.get(1).click();
        AllCheckBoxes.get(2).click();
    }

    @Test
    public void RadioTest(){
        List<WebElement> AllRadio = driver.findElements(By.className("vfb-radio"));

        AllRadio.get(0).click();
        AllRadio.get(1).click();
        AllRadio.get(2).click();
    }

    @Test
    public void SelectTest(){
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"vfb-12\"]")));

        dropdown.selectByIndex(2);
    }

    @Test
    public void DragTest(){
        WebElement secondElement = driver.findElement(By.id("dragb"));;

        element = driver.findElement(By.id("draga"));

        Actions builder = new Actions(driver);

        Action dragAndDrop = builder.clickAndHold(element).
                release(secondElement).
                build();

        dragAndDrop.perform();
    }

    @Test
    public void AlertTest() throws InterruptedException {
       element = driver.findElement(By.xpath("//*[@id=\"alert\"]"));

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250)", "");

        element.click();

         driver.switchTo().alert().accept();
    }

    @Test
    public void VerificationTest(){
        element = driver.findElement(By.xpath("//*[@id=\"vfb-3\"]"));
        element.sendKeys("332");
        element.sendKeys(Keys.ENTER);

        driver.findElement(By.className("vfb-error")).isDisplayed();

        element.clear();
        element.sendKeys("32");
        element.sendKeys(Keys.ENTER);

        driver.navigate().back();
    }

    @AfterClass
    public static void cleanp() {

        //driver.quit();
    }
}
