package testCases;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC002_Login extends BaseClass {
    private static final Logger log = LoggerFactory.getLogger(TC002_Login.class);
    String expectedConfirmationMessage="MY DASHBOARD";
    HomePage home ;
    LoginPage login;
    RegistrationPage register;
    @Test
    public void RegisterTest() throws InterruptedException {
        /*


        home.ClickAccount();
        home.ClickRegister();
        register.ValidRegister();

         */
        home = new HomePage(driver);
        home.ClickAccount();


        register=new RegistrationPage(driver);
        register.ClickBtnLogout();
        login = new LoginPage(driver);
        home.ClickAccount();
        home.ClickLogin();
        login.ValidLogin();
        String actualConfirmationMessage = login.verifyLoginSuccessful();
        Assert.assertEquals(actualConfirmationMessage,expectedConfirmationMessage);


    }



}
