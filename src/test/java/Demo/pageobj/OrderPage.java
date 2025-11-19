package Demo.pageobj;
import Demo.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {

    public WebDriver driver;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    public boolean getOrderNames(String prodName){

        List<WebElement> rows = driver.findElements(By.cssSelector("tr td:nth-child(3)"));

        return rows.stream()
                .anyMatch(s ->
                        s.getText().contains(prodName)
                );


    }




}
