package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class autoSuggestAssignment {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String text = "india";

        driver.findElement(By.id("autocomplete")).sendKeys("ind");

        Thread.sleep(1000);
        List<WebElement> cnt = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));

        WebElement autoSuggest = driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]"));

        autoSuggest.click();

        /* Actions move = new Actions(driver);
        move.moveToElement(autoSuggest).build().perform();
        move.click(autoSuggest);*/

    }
}
