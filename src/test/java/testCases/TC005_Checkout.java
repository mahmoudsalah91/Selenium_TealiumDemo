package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.CheckoutPage;
import testBase.BaseClass;

public class TC005_Checkout extends BaseClass {
    SoftAssert softAssert = new SoftAssert();
    CheckoutPage checkout;
   String expectedSuccessMessage="Your order has been received.";
    @Test()
    public void CheckOut() {
        checkout=new CheckoutPage(driver);
        checkout.shippingInfo();
        checkout.shippingMethod();
        checkout.paymentInformation();


        int actualSubTotalOnCart=checkout.SubTotalOnCart();
        int expectedSubTotalOnCart= checkout.VerifySubTotal();
        softAssert.assertEquals(actualSubTotalOnCart,expectedSubTotalOnCart);

        int actualGrandTotalOnCart=checkout.GrandTotalOnCart();
        int expectedGrandTotalOnCart= checkout.VerifyGrandTotal();
        softAssert.assertEquals(actualGrandTotalOnCart,expectedGrandTotalOnCart);

        checkout.confirmOrder();
        String actualSuccessMessage = checkout.confirmMessage();
        softAssert.assertEquals(actualSuccessMessage,expectedSuccessMessage);
    }
}
