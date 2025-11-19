package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDropUsingIFrame {


    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        //to get how many iframes there are
        //System.out.println(driver.findElements(By.tagName("iframe")).size());
        //to go to iframe using index or in by knowing the count of iframe
        //driver.switchTo().frame(0);

        //go to iframe using webelement
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));


        Actions drag = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Thread.sleep(1000);
        drag.dragAndDrop(source, target).build().perform();

        //going back to default content
        driver.switchTo().defaultContent();

    }
}
