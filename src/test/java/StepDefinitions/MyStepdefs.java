package StepDefinitions;

import MoreMethodsForMoreTransactions.UseableMethods;
import PageObjectModels.MainPage;
import PageObjectModels.RandomProductPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyStepdefs {
    protected WebDriver driver;
    MainPage mainPage;
    UseableMethods useableMethods;
    RandomProductPage randomProductPage;
    public MyStepdefs() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage=new MainPage(driver);
        randomProductPage=new RandomProductPage(driver);

    }


 @Given("I navigate to main url$")
    public void ıNavigateToMainUrl(){
        mainPage.CheckSiteIsLodedSuccessFully();

  }

    @When("I check {int} titles on the mainpage")
    public void ıCheckTitlesOnTheMainpage(int HeadCounts) {
        mainPage.CountAllHeads(HeadCounts);
    }
    @Then("I take screenshot and save as {string}")
    public void ıTakeScreenshotAndSaveAs(String caseEndsNameWith) {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File screenShot=ts.getScreenshotAs(OutputType.FILE);
        String abspath= Paths.get("src\\test\\resources\\screenshots").toAbsolutePath().toString();
        String filename=caseEndsNameWith+"-"+System.currentTimeMillis()+".png";
        String path=abspath+"\\"+filename;
        try {
            FileUtils.copyFile(screenShot,new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Given("I go to products tab and click randomly a product")
    public void ıGoToProductsTabAndClickRandomlyAProduct() {
        mainPage.GoProductTabAndChooseARandomProduct();
    }


    @When("I see the product is loaded successfully")
    public void ıSeeTheProductPageWithRightTitle() {
        randomProductPage.IsLodedSuccessFully();
    }


    @When("I check are we at the right page")
    public void ıCheckAreWeAtTheRightPage() {
        randomProductPage.checkRandomProductUri();
    }

    @Then("I should see all informations tabs has their explonations")
    public void ıShouldSeeAllInformationsTabsHasTheirExplonations(){
        randomProductPage.CustomerShouldSeeAllInformationsTab();
    }
    @After()
    public void Quit() {
        if (driver != null) {
            driver.quit();

        }
    }
}
