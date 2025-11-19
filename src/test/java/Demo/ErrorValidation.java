package Demo;

import Demo.base.BaseTest;
import Demo.pageobj.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidation extends BaseTest {

    ProductCatalog prdCatalog;

    @Test
    public void startUp() {

        prdCatalog = landObj.LoginApplication("janweir@gmail.com", "Janweir@1");
        Assert.assertEquals(landObj.errorMessage(), "Incorrect email or password.");

    }

}
