package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;


public class BasePage {
       WebDriver driver;
    BasePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public static String randomString()
    {
        return RandomStringUtils.randomAlphabetic(5);
    }
    public static String randomNumber ()
    {
        return RandomStringUtils.randomNumeric(5);
    }

    public static int converter(String amount)
    {
        String price =amount.replace("$","");
        double amountDouble=Double.parseDouble(price);
        int amountInt = (int) Math.round(amountDouble);
        return amountInt;


    }
}

