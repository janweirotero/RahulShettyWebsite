package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class checkWindow {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.cssSelector("a[href='/windows']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String parentId = it.next();
        String childId =  it.next();

        driver.switchTo().window(childId);
        String newText = driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText();
        System.out.println(newText);
        driver.switchTo().window(parentId);
        String parentText = driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText();
        System.out.println(parentText);
    }
}
