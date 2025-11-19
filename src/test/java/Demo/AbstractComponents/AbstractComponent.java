package Demo.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
    WebDriverWait wait;

    public AbstractComponent(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void waitForElementToAppear(WebElement select){
        wait.until(ExpectedConditions.invisibilityOf(select));
    }

    public void waitForErrorMessage(WebElement findBy){
        wait.until(ExpectedConditions.visibilityOf(findBy));


    }



}
