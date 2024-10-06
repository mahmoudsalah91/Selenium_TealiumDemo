package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {
    String expectedConfirmationMessage="Thank you for registering with Tealium Ecommerce.";
    RegistrationPage register = new RegistrationPage(driver);
    HomePage home = new HomePage(driver);
    @Test
    public void RegisterTest() throws InterruptedException {
        home = new HomePage(driver);
        home.ClickAccount();
        home.ClickRegister();
        register = new RegistrationPage(driver);
        register.ValidRegister();
        String actualConfirmationMessage = register.confirmMessage();
        Assert.assertEquals(actualConfirmationMessage,expectedConfirmationMessage);
        register.saveCredentialToProperties();
    }



}
