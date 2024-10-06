package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.FileUtility;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);

    }
    String productPrice;

    String productName= FileUtility.getFile("testData").getString("productName");
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    By productNames= By.xpath("//h2[@class='product-name']");
    By btn_productDetail_loc=By.linkText(productName);
    By btn_AddToCart_loc=By.xpath("//button[@onclick='productAddToCartForm.submit(this)']");
    By txt_productPrice=By.xpath("//span[@class='price']");

    public List<String> searchResult()
    {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNames));
        List<WebElement> products=driver.findElements(productNames);
        List<String>productNames=new ArrayList<>();
        for(WebElement product :products)
        {
            productNames.add(product.getText());
        }
        return productNames;
    }

    public void navigateProductDetail()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_productDetail_loc)).click();
    }
   public void clickAddToCart()
   {
       wait.until(ExpectedConditions.visibilityOfElementLocated(btn_AddToCart_loc)).click();
   }
   public String productPrice() {

       try {
           productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(txt_productPrice)).getText();
           return productPrice;
       } catch (Exception e) {
           return"product price is not present as " + e;
       }

   }
}
