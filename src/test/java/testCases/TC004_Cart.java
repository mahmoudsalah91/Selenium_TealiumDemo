package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.FileUtility;

import java.util.List;

public class TC004_Cart extends BaseClass {
    SoftAssert softAssert = new SoftAssert();
    HomePage home;
    SearchPage search;
    CartPage cart;

    @Test
    public void ShoppingCart ()
    {
        /*
        home = new HomePage(driver);
        home.SearchProduct();
        search=new SearchPage(driver);
        List<String> SearchResult=search.searchResult();
        String searchKeyword= FileUtility.getFile("testData").getString("productCategory");
        for(String searchProducts:SearchResult)
        {
            softAssert.assertTrue(searchProducts.contains(searchKeyword));
        }

         */
        search=new SearchPage(driver);
        search.navigateProductDetail();
        String productPrice=search.productPrice();
        System.out.println(productPrice);
        search.clickAddToCart();

        cart=new CartPage(driver);
        String productPriceOnCart=cart.productPriceOnCart();
        System.out.println(productPriceOnCart);
        softAssert.assertEquals(productPriceOnCart,productPrice);

        int actualSubTotalOnCart=cart.SubTotalOnCart();
        int expectedSubTotalOnCart= cart.VerifySubTotal();
        softAssert.assertEquals(actualSubTotalOnCart,expectedSubTotalOnCart);

        int actualGrandTotalOnCart=cart.GrandTotalOnCart();
        int expectedGrandTotalOnCart= cart.VerifyGrandTotal();
        softAssert.assertEquals(actualGrandTotalOnCart,expectedGrandTotalOnCart);

        cart.clickCheckOut();



    }
}
