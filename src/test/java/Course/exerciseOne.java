package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class exerciseOne {

    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> chkbox = driver.findElements(By.xpath("//div[@class='right-align']//label"));
        int cnt = chkbox.size();

        for (int i=0;i<=cnt;i++){

            String selChkBox = chkbox.get(i).getText();

            if (selChkBox.equalsIgnoreCase("Option2")){
                driver.findElement(By.id("checkBoxOption2")).click();

                WebElement selDropDwn = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
                Select drpDwn = new Select(selDropDwn);
                drpDwn.selectByVisibleText(selChkBox);

                Thread.sleep(1000);
                driver.findElement(By.xpath("//input[@id='name']")).sendKeys(selChkBox);
                Thread.sleep(1000);
                driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
                Thread.sleep(1000);
                driver.switchTo().alert().accept();

                break;

            }




        }







    }
}
