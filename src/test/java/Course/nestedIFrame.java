package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class nestedIFrame {

    public static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[normalize-space()='Nested Frames']")).click();
        //driver.switchTo().frame(driver.findElement(By.name("frameset-middle")));

        //get the count of iframes
        //System.out.println(driver.findElements(By.tagName("frame")).size());

        driver.switchTo().frame(0);

        //get the count of iframes
        //System.out.println(driver.findElements(By.tagName("frame")).size());
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.id("content")).getText());

    }
}
