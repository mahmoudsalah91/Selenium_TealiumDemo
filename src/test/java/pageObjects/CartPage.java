package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    String productPriceOnCart;
    int SubTotal;

    By btn_CheckOut_loc=By.xpath("//span[contains(text(),'Proceed to Checkout')]");
    By txt_productPriceOnCart_loc=By.xpath("//td[@class='product-cart-price']//span[@class='price']");
    By txt_Quantity_loc=By.xpath("//input[@title='Qty']");
    By txt_SubTotal_loc=By.xpath("//td[@class='product-cart-total']//span[@class='price']");
    By txt_TAX_loc=By.xpath("//td[normalize-space()='Tax']//following::span[@class='price']");
    By txt_GrandTotal=By.cssSelector("strong span[class='price']");


    public void clickCheckOut()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_CheckOut_loc)).click();
    }
    public String productPriceOnCart() {

        try {
            productPriceOnCart = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_productPriceOnCart_loc)).getText();
            return productPriceOnCart;
        } catch (Exception e) {
            return"product Price OnCart price is not present as " + e;
        }

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



    public int VerifySubTotal() {

        String productPriceOnCart = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_productPriceOnCart_loc)).getText();
        System.out.println(productPriceOnCart);
        int productPriceOnCartInt = converter(productPriceOnCart);
        System.out.println("productPriceOnCartInt = " +productPriceOnCartInt);
        String Quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Quantity_loc)).getAttribute("value");
        int QuantityInt =converter(Quantity);
        System.out.println(QuantityInt);
        int VerifySubTotal= QuantityInt*productPriceOnCartInt;



        return VerifySubTotal;

    }

    public int VerifyGrandTotal() {

        String SubTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_SubTotal_loc)).getText();
        int SubTotalInt =converter(SubTotal);
        /*
        String TAX = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_TAX_loc)).getText();
        int TAXInt =converter(TAX);


         */
        int VerifyGrandTotal= SubTotalInt;



        return VerifyGrandTotal;
    }





}
