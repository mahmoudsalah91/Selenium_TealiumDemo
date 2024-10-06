package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.FileUtility;

import java.util.List;

public class TC003_ProductSearch extends BaseClass {
    SoftAssert softAssert = new SoftAssert();
    HomePage home;
    SearchPage search;
    @Test
    public void validateSearchResult()
    {
        home=new HomePage(driver);
        home.SearchProduct();
        search=new SearchPage(driver);
        List<String>SearchResult=search.searchResult();
        String searchKeyword= FileUtility.getFile("testData").getString("productCategory");
        for(String searchProducts:SearchResult)
        {
            softAssert.assertTrue(searchProducts.contains(searchKeyword));
        }
    }
}
