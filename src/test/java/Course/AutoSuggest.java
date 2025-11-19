package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class AutoSuggest {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.xpath("(//input[@id='checkBoxOption1'])[1]")).click();

        System.out.println(driver.findElement(By.xpath("(//input[@id='checkBoxOption1'])[1]")).isSelected());

        Assert.assertTrue(driver.findElement(By.xpath("(//input[@id='checkBoxOption1'])[1]")).isSelected());



        System.out.println(driver.findElement(By.xpath("(//input[@id='checkBoxOption1'])[1]")).isSelected());

        Assert.assertFalse(driver.findElement(By.xpath("(//input[@id='checkBoxOption1'])[1]")).isSelected());

        System.out.print(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        //driver.findElement(By.xpath("(//input[@id='checkBoxOption1'])[1]")).click();

    }
}
