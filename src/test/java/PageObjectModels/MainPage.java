package PageObjectModels;

import MoreMethodsForMoreTransactions.UseableMethods;
import io.cucumber.java.en_old.Ac;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainPage {
    protected WebDriver driver;
    protected String BaseUrl="https://www.anadolusigorta.com.tr/";

    protected Logger logger= LoggerFactory.getLogger(MainPage.class);

    By productTab=By.xpath("//a[@class='productsMegaMenu']");
    By randomProduct;
    By TitleList=By.xpath("//h2");
    WebElement AcceptCookies;
    UseableMethods useableMethods;
    public MainPage(WebDriver driver){
    this.driver=driver;
        useableMethods=new UseableMethods(driver);
    }
    public void CheckSiteIsLodedSuccessFully(){
        driver.get(BaseUrl);
        useableMethods.PageLoadedSuccessFully();
        AcceptCookies=driver.findElement(By.xpath("//*[contains(text(),'Tümünü Kabul Et')]"));
        useableMethods.WaitUntillSeeElementAndClick(AcceptCookies);
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl);

    }
    public boolean CountAllHeads(int TitleCount){
        List<WebElement> Titles=driver.findElements(TitleList);
        return TitleCount==Titles.size();

    }

    public void GoProductTabAndChooseARandomProduct() {
        driver.findElement(productTab).click();
        Random random = new Random();
        List<WebElement> productList = driver.findElements(By.xpath("(//div[@class='productsMenuListContainer']//*[contains(text(),'Sigorta')])"));
        int randomProductIndex = random.nextInt(productList.size());
        randomProduct = By.xpath("(//div[@class='productsMenuListContainer']//*[contains(text(),'Sigorta')])" + "[" + randomProductIndex + "]");
        if (driver.findElement(randomProduct).isDisplayed()) {
            logger.info(driver.findElement(randomProduct).getText()
                    + " will choose by automation");
        } else {
            logger.info("Product is not clickable");
        }
        //we add the product name an excel and later we will check are we at the right page
        String datasPath = "src\\test\\java\\ProductPageUriPath\\ProductPageUriPath.xlsx";
        try (FileInputStream file = new FileInputStream(datasPath)) {
            Workbook companyInformations = WorkbookFactory.create(file);
            Sheet sheet = companyInformations.getSheetAt(0);
            Row row = sheet.getRow(1);

            Cell productUripath = row.getCell(0);
            if (productUripath != null) {
                productUripath.setBlank();
            } else {

            }

            productUripath.setCellValue(driver.findElement(randomProduct).getText());
            try (FileOutputStream fileOutputStream = new FileOutputStream(datasPath)) {
                companyInformations.write(fileOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            companyInformations.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.findElement(randomProduct).click();
    }
}
