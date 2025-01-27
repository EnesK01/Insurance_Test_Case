package PageObjectModels;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RandomProductPage extends MainPage {


By MainTitle=By.xpath("//h1");
By InsuranceDetailsIcon=By.xpath("(//div[@id='homeAccordion']/div/div/i)[1]");
By InsuranceDetailstText=By.xpath("(//*[@class='contents_text']/div/p)[1]");
By WhatContains=By.xpath("(//div[@id='homeAccordion']/div/div/i)[2]");
By WhatContainsText=By.xpath("(//*[@class='contents_text']/div/p)[2]");
By SpecialServices=By.xpath("(//div[@id='homeAccordion']/div/div/i)[3]");
By SpecialServicesText=By.xpath("(//*[@class='contents_text']/div/p)[3]");
    public RandomProductPage(WebDriver driver) {
        super(driver);
    }

    public void IsLodedSuccessFully() {
        useableMethods.PageLoadedSuccessFully();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkRandomProductUri() {
        String datasPath = "src\\test\\java\\ProductPageUriPath\\ProductPageUriPath.xlsx";
        String uri="";
        try {
           FileInputStream file = new FileInputStream(datasPath);
            Workbook ProductPageUripath = WorkbookFactory.create(file);
            Sheet sheet=ProductPageUripath.getSheetAt(0);
            Row row= sheet.getRow(1);
            Cell cell=row.getCell(0);
             uri =cell.toString();
           Assert.assertTrue(driver.findElement(MainTitle).getText().contains(uri));
            ProductPageUripath.close();
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void CustomerShouldSeeAllInformationsTab(){

        useableMethods.untilSeeElement(InsuranceDetailsIcon);
            if(driver.findElement(InsuranceDetailsIcon).isDisplayed()){
                driver.findElement(InsuranceDetailsIcon).click();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(driver.findElement(InsuranceDetailstText).getText()!=null){
                    logger.info(driver.findElement(InsuranceDetailstText).getText()+ " Insurance Detail is not empty");
                }else{
                    logger.info("There is no text in Insurance Details.");
                }
            }else{
                logger.info(InsuranceDetailsIcon+" The product does not have a title.");
            }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        useableMethods.untilSeeElement(WhatContains);
        if(driver.findElement(WhatContains).isDisplayed()){
            driver.findElement(WhatContains).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(driver.findElement(WhatContainsText).getText()!=null){
                logger.info(driver.findElement(WhatContainsText).getText()+ " What it Inclueds is not empty");
            }else{
                logger.info("There is no text in Insurance Details..");
            }
        }else{
            logger.info(WhatContains+" The product does not have a title.");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        useableMethods.untilSeeElement(SpecialServices);
        if(driver.findElement(SpecialServices).isDisplayed()){
            driver.findElement(SpecialServices).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(driver.findElement(SpecialServicesText).getText()!=null){
                logger.info(driver.findElement(SpecialServicesText).getText()+ " Special services is not empty");
            }else{
                logger.info("There is no text in Insurance Details.");
            }
        }else{
            logger.info(SpecialServices+" The product does not have a title.");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }





}
