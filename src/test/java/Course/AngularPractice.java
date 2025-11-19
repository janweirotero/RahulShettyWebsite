package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AngularPractice {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("My_Name");
        driver.findElement(By.name("email")).sendKeys("MyName@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("12345678");

        driver.findElement(By.id("exampleCheck1")).click();

        //Selects dropdown
        WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
        Select SelGender = new Select(gender);
        SelGender.selectByVisibleText("Female");

        driver.findElement(By.id("inlineRadio1")).click();

        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/form-comp[1]/div[1]/form[1]/div[7]/input[1]")).sendKeys("03/07/1998");

        driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

        //System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
        System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());


    }
}
