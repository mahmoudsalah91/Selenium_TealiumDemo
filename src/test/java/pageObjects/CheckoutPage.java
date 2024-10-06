package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By txt_Address_loc=By.xpath("//input[@id='billing:street1']");
    By txt_City_loc=By.xpath("//input[@id='billing:city']");
    By txt_Zip_loc=By.xpath("//input[@id='billing:postcode']");
    By txt_State_loc=By.xpath("//select[@id='billing:region_id']");
    By DDL_Country_loc =By.xpath("//select[@id='billing:country_id']");
    By txt_Telephone_loc=By.xpath("//input[@id='billing:telephone']");

    By btn_ShippingSave_loc=By.xpath("//button[@onclick='billing.save()']");
    By btn_shippingMethodSave_loc=By.xpath("//button[@onclick='shippingMethod.save()']");
    By btn_paymentInformationSave_loc= By.xpath("//button[@onclick='payment.save()']");

    By btn_shipping_method_loc=By.xpath("//input[@id='s_method_freeshipping_freeshipping']");

    By txt_productPriceOnCart_loc=By.cssSelector("td[class='a-right'] span[class='price']");
    By txt_Quantity_loc=By.cssSelector("td[class='a-center']");
    By txt_SubTotal_loc=By.cssSelector("td[class='a-right last'] span[class='cart-price'] span[class='price']");
    By txt_GrandTotal=By.cssSelector("strong span[class='price']");

    By btn_PlaceOrder_loc=By.xpath("//span[contains(text(),'Place Order')]");

    By btn_confirmMessage_loc=By.xpath("//h1[normalize-space()='Your order has been received.']");

    public void shippingInfo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Address_loc)).sendKeys(randomString());
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_City_loc)).sendKeys(randomString());
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Zip_loc)).sendKeys(randomNumber());
        wait.until(ExpectedConditions.visibilityOfElementLocated(DDL_Country_loc));
        Select countryDD = new Select(driver.findElement(DDL_Country_loc));
        countryDD.selectByValue("EG");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(txt_State_loc)).sendKeys(randomString());
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Telephone_loc)).sendKeys(randomNumber());
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ShippingSave_loc)).click();



    }
    public void shippingMethod(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_shipping_method_loc)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_shippingMethodSave_loc)).click();
    }


    public void paymentInformation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_paymentInformationSave_loc)).click();


    }

    public int SubTotalOnCart() {

        String SubTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_SubTotal_loc)).getText();
        int SubTotalInt = converter(SubTotal);
        return SubTotalInt;

    }

    public int GrandTotalOnCart() {

        String GrandTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_GrandTotal)).getText();
        int GrandTotalInt =converter(GrandTotal);
        return GrandTotalInt;

    }

    public int VerifySubTotal(){
        String productPriceOnCart = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_productPriceOnCart_loc)).getText();
        System.out.println(productPriceOnCart);
        int productPriceOnCartInt = converter(productPriceOnCart);
        System.out.println("productPriceOnCartInt = " +productPriceOnCartInt);
        String Quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Quantity_loc)).getText();
        int QuantityInt =converter(Quantity);
        System.out.println(QuantityInt);
        int VerifySubTotal= QuantityInt*productPriceOnCartInt;



        return VerifySubTotal;
    }

    public int VerifyGrandTotal() {

        String SubTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_SubTotal_loc)).getText();
        int SubTotalInt =converter(SubTotal);
        int VerifyGrandTotal= SubTotalInt;



        return VerifyGrandTotal;
    }


    public void confirmOrder(){
    wait.until(ExpectedConditions.visibilityOfElementLocated(btn_PlaceOrder_loc)).click();

    }

    public String confirmMessage()
    {
        try
        {
           String confirmMessage =wait.until(ExpectedConditions.visibilityOfElementLocated(btn_confirmMessage_loc)).getText();
           return confirmMessage;
        }
        catch (Exception e){
            return "purchase order unsuccessful"+e;
        }

    }






}
