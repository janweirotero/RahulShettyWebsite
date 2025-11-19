package Demo.pageobj;

import Demo.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Demo.pageobj.OrderPage;

public class LandingPage extends AbstractComponent {

   public WebDriver driver;
   ProductCatalog prdCatalog;
   OrderPage ordObj;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
            WebElement userEmail;
    //By userEmail = By.id("userEmail");

    By userPass = By.id("userPassword");
    By loginUser = By.id("login");

    @FindBy(id = "toast-container")
        WebElement errorMessage;

   @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
        WebElement orderPage;


    public ProductCatalog LoginApplication(String email, String pass){

        prdCatalog = new ProductCatalog(driver);

        userEmail.sendKeys(email);
        driver.findElement(userPass).sendKeys(pass);
        driver.findElement(loginUser).click();

        return prdCatalog;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

    public String errorMessage(){

        waitForErrorMessage(errorMessage);
        return errorMessage.getText();

    }

    public OrderPage goToOrderPage(){

        ordObj = new OrderPage(driver);
        orderPage.click();

        return ordObj;

    }


}
