package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class calendarTest {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.findElement(By.xpath("//a[normalize-space()='Top Deals']")).click();

        String year = "2027", date = "7", month = "3";
        String[] expected = {month,date,year};

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
        selYear(year);
        selMonth(month);
        selDate(date);

        List<WebElement> calendar = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        int cnt = calendar.size();
        for (int i=0;i <= cnt;i++){

            //get the value of the calendar
           String newText = calendar.get(i).getDomAttribute("value");
           Assert.assertEquals(newText,expected[i]);

           break;
        }

        driver.switchTo().window(parentId);

        //driver.quit();

    }

    public static void selYear(String year){

        driver.findElement(By.name("year")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='"+year+"']")).click();

    }

    public static void selMonth(String month){
        driver.findElement(By.xpath("//div[@class='react-calendar__viewContainer']//button["+month+"]")).click();
    }

    public static void selDate(String dateito){

        driver.findElement(By.xpath("//abbr[@aria-label='March "+dateito+", 2027']")).click();

    }
}
