package Demo;

import Demo.base.BaseTest;
import Demo.pageobj.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class StandAloneTest extends BaseTest{


    CartPage cartObj;
    ProductCatalog prdCatalog;
    CheckoutPage chkObj;
    ConfirmationPage cnfrmObj;


    @Test
    public void startUp() {

        String prodName = "ZARA", nameProd = "ZARA COAT 3";

        prdCatalog = landObj.LoginApplication("janweir@gmail.com", "Janweir@1234");
        prdCatalog.addProdToCart(prodName);
        cartObj = prdCatalog.goToCart();
        Boolean chk = cartObj.getTheText(nameProd);
        Assert.assertTrue(chk);
        chkObj = cartObj.clickTheButton();
        cnfrmObj = chkObj.inputCountry("ind");

    }



}
