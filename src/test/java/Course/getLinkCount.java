package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class getLinkCount {

    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //limit the webdriver
        WebElement footer = driver.findElement(By.id("gf-BIG"));

        //create a sub webdriver, getting only the footer elements
        // System.out.print(footer.findElements(By.tagName("a")).size());
        int count = driver.findElements(By.xpath("//div[@id='gf-BIG']//table/tbody/tr/td[1]/ul/li/a")).size(), j=0;
        footer.findElements(By.xpath("//div[@id='gf-BIG']//table/tbody/tr/td[1]/ul/li"));

       for (int i=1;i<=count;i++){

           String chars = Keys.chord(Keys.COMMAND,Keys.ENTER);
           footer. findElements(By.tagName("a")).get(i).sendKeys(chars);
           Thread.sleep(5000);
       }

        Set<String> windows = driver.getWindowHandles();
        //Iterator<String> it = windows.iterator();

        for(String windowshandle : windows ){

            System.out.println(driver.switchTo().window(windowshandle).getTitle());


        }


    }

}
