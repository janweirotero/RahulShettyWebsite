package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Javascript {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys("ej");
        driver.findElement(By.id("alertbtn")).click();

        Thread.sleep(1000);
        //switch to alert(javascript), select ok
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys("ej");
        driver.findElement(By.id("confirmbtn")).click();

        Thread.sleep(1000);
        //switch to alert(javascript), select ok
        driver.switchTo().alert().accept();

    }
}
