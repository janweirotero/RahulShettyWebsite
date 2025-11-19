package Demo.pageobj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public WebDriver driver;

    //this is a constructor method this comment is just a test in github
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath = "(//button[@class=\"ta-item list-group-item ng-star-inserted\"])[2]")
    WebElement country;
    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement inputCountry;

    By checkOut = By.xpath("//a[normalize-space()='Place Order']");

    public ConfirmationPage inputCountry(String inpCountry){

        ConfirmationPage cnfrmObj  = new ConfirmationPage(driver);

        inputCountry.sendKeys(inpCountry);
        selectCountry();
        return cnfrmObj;

    }

    public void selectCountry(){

        Actions act = new Actions(driver);
        act.moveToElement(country).click().build().perform();
        driver.findElement(checkOut).click();



    }

}
