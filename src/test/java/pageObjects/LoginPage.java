package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.FileUtility;

import java.time.Duration;

public class LoginPage extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    String MyDashboard;


    By txt_Email_loc = By.xpath("//input[@id='email']");
    By txt_Password_loc = By.id("pass");
    By btn_Login_loc = By.id("send2");
    By txt_MyDashboard_loc = By.xpath("//h1[normalize-space()='My Dashboard']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String Email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Email_loc)).sendKeys(Email);
    }
    public void setPass(String Password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Password_loc)).sendKeys(Password);
    }

    public void ClickBtnLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Login_loc)).click();
    }

    public void ValidLogin()
    {

        String validEmail= FileUtility.getFile("validLoginData").getString("Email");
        String validPassword=  FileUtility.getFile("validLoginData").getString("Password");
        setEmail(validEmail);
        setPass(validPassword);
        ClickBtnLogin();
    }

    public String verifyLoginSuccessful() {
        try {
            MyDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_MyDashboard_loc)).getText();
            System.out.println(MyDashboard);
            return MyDashboard;
        } catch (Exception e) {
            return "MyDashboard is not present as :" + e;
        }


    }
}


