package MoreMethodsForMoreTransactions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;

public class UseableMethods {
    protected WebDriver driver;
    private static final Logger logger= LoggerFactory.getLogger(UseableMethods.class);
    JavascriptExecutor executor;
    Actions actions;
    Robot robot;
    WebDriverWait wait;
    public UseableMethods(WebDriver driver){
        this.driver=driver;
        executor=(JavascriptExecutor) driver;
        actions=new Actions(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void PageLoadedSuccessFully(){


        while (!executor.executeScript("return document.readyState").equals("complete")) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("page loaded successfully");

    }
    public void MoveToElementNotClick(WebElement element){
        actions.moveToElement(element).perform();
    }
    public void WaitUntillSeeElementAndClick(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
    public void ScrollDownAtHomePage(){
        executor.executeScript("window.scrollBy(0,500)","");
    }
    public void untilSeeElement(By element) {

        while (true) {
            executor.executeScript("window.scrollBy(0,150);");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean isElementVisible = driver.findElement(element).isDisplayed();

            if (isElementVisible) {
                break;
            }
        }
    }
}
