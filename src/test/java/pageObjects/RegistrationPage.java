package pageObjects;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Duration;
import java.util.Properties;

public class RegistrationPage extends BasePage {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String confirmMessage;
      Faker faker = new Faker();
    public  String Email = faker.internet().safeEmailAddress();
    public  String Password = faker.internet().password();
    Properties properties = new Properties();
    public   String PROPERTIES_FILE = "src/test/resources/validLoginData.properties";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private  By txt_FistName_loc = By.id("firstname");
    private  By txt_MiddleName_loc = By.id("middlename");
    private  By txt_LastName_loc = By.id("lastname");
    private  By txt_EmailAddress_loc = By.id("email_address");
    private  By txt_Password_loc = By.id("password");
    private  By txt_ConfirmationPassword_loc = By.id("confirmation");
    private  By ChBox_IsSubscribed_loc = By.id("is_subscribed");
    private  By ChBox_RememberMe_loc = By.xpath("//input[@title='Remember Me']");
    private  By btn_Register_loc = By.xpath("//button[@title='Register']");
    private By txt_ConfirmMessage_loc=By.xpath("//span[normalize-space()='Thank you for registering with Tealium Ecommerce.']");
    private  By btn_Logout_loc = By.xpath("//a[normalize-space()='Log Out']");


    public  void setFistName(String FistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_FistName_loc)).sendKeys(FistName);
    }
    public  void setMiddleName(String MiddleName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_MiddleName_loc)).sendKeys(MiddleName);
    }
    public  void setLastName(String LastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_LastName_loc)).sendKeys(LastName);
    }
    public  void setEmailAddress(String EmailAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_EmailAddress_loc)).sendKeys(EmailAddress);
    }
    public  void setPassword(String Password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Password_loc)).sendKeys(Password);
    }
    public  void setConfirmationPassword(String ConfirmationPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_ConfirmationPassword_loc)).sendKeys(ConfirmationPassword);
    }
    public  void ClickChBoxIsSubscribed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChBox_IsSubscribed_loc)).click();
    }
    public  void ClickChBoxRememberMe() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChBox_RememberMe_loc)).click();
    }
    public  void ClickBtnRegister() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Register_loc)).click();
    }
    public  void ClickBtnLogout() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Logout_loc)).click();
        Thread.sleep(3000);
    }

    public  void ValidRegister() throws InterruptedException {

        setFistName(faker.name().firstName());
        setMiddleName(faker.name().nameWithMiddle());
        setLastName(faker.name().lastName());
        setEmailAddress(Email);
        setPassword(Password);
        setConfirmationPassword(Password);
        ClickChBoxIsSubscribed();
        ClickChBoxRememberMe();
        ClickBtnRegister();
        Thread.sleep(3000);


    }



    public String confirmMessage() {
        try {
            confirmMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_ConfirmMessage_loc)).getText();
            System.out.println(confirmMessage);
            return confirmMessage;
        }catch (Exception e)
        {
            return "the confirmMessage not present as :"+e;
        }
    }

    public void saveCredentialToProperties() {
            properties = new Properties();
        try (OutputStream output = new FileOutputStream(PROPERTIES_FILE)) {
            properties.setProperty("Email", Email);
            properties.setProperty("Password", Password);
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.navigate().to("https://ecommerce.tealiumdemo.com/");
    }
}
