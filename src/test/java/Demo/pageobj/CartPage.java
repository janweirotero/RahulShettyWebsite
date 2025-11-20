package Demo.pageobj;
import Demo.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponent {

    public WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = ".cartSection h3")
        WebElement getName;

    @FindBy(xpath ="//ul/li/button[@class='btn btn-primary']" )
        WebElement clickBtn;


    public Boolean getTheText(String nameProd){

        //this will return the text of the element
        return getName.getText().equalsIgnoreCase(nameProd);


    }

    public CheckoutPage clickTheButton(){

        CheckoutPage chckObj = new CheckoutPage(driver);

        clickBtn.click();
        return chckObj;
    }



}
