package Demo;
import Demo.base.BaseTest;
import Demo.pageobj.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.*;
import Demo.pageobj.OrderPage;

public class SubmitOrderTest extends BaseTest {

    ProductCatalog prdCatalog;
    OrderPage ordObj;


    @Test(dataProvider="getData", groups={"MultipleItems"})
    public void goToOrdersPage(String email, String pass, String prodName){

        prdCatalog = landObj.LoginApplication(email, pass);
        ordObj = landObj.goToOrderPage();
        Assert.assertTrue(ordObj.getOrderNames(prodName));

    }


    @DataProvider
    public Object[][] getData(){

      return new Object[][] {{"janweir2@gmail.com","Janweir@1234","ZARA COAT 3"},{"janweir@gmail.com","Janweir@1234","ZARA COAT 3"}};

    }




}
