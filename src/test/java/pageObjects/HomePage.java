package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.FileUtility;

import java.time.Duration;
import java.util.Properties;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));

     By btn_Account_loc =By.xpath("//span[@class='label'][text()='Account']");
     By btn_Register_loc =By.xpath("//a[text()='Register']");
     By btn_Login_loc =By.xpath("//a[text()='Log In']");
     By txt_Search_loc=By.xpath("//input[@id='search']");
     By btn_Search_loc=By.xpath("//button[@title='Search']");
    public void ClickAccount()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Account_loc)).click();
    }
    public void ClickRegister()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Register_loc)).click();
    }
    public void ClickLogin()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Login_loc)).click();
    }
    public void SearchProduct()
    {
        String searchProductName= FileUtility.getFile("testData").getString("productCategory");
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Search_loc)).sendKeys(searchProductName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Search_loc)).click();

    }

}
