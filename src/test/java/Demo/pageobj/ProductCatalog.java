package Demo.pageobj;

import Demo.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductCatalog extends AbstractComponent {

   public WebDriver driver;
   CartPage cartObj;


    public ProductCatalog(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[@routerlink=\"/dashboard/cart\"])[1]")
            WebElement clickCart;

    By getProd = By.cssSelector(".card-body button:last-of-type");
    By message = By.xpath("//div[@id='toast-container']");

    public WebElement getProdName(String prodName1)  {

        List<WebElement> rows = driver.findElements(By.xpath("(//div[@class='row'])[3]"));

        return rows.stream()
                .filter(s ->
                        s.findElement(By.cssSelector("b")).getText().contains(prodName1)
                )
                .findFirst()
                .orElse(null);


    }

    public void  addProdToCart(String prodName1)  {

        WebElement newProd = getProdName(prodName1);
        newProd.findElement(getProd).click();

        WebElement popup = driver.findElement(message);
        waitForElementToAppear(popup);

    }

    public CartPage goToCart(){

        cartObj = new CartPage(driver);
        clickCart.click();

        return cartObj;
    }




}
