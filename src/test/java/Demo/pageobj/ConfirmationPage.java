package Demo.pageobj;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    WebDriver driver;

    //this is for confirmation page
    public ConfirmationPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//h1[normalize-space()=\"Thankyou for the order.\"]")
    String getMessage;

    public void confirmMessage(){

        //just to check if there is an order
        //git comment testing only
        Assert.assertTrue(getMessage.equalsIgnoreCase("//h1[normalize-space()=\"Thankyou for the order.\"]"));

    }

}
