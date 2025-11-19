package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Passingarraytocart {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //create string for veggiesName
        String[] veggiesName = {"Brocolli","Tomato","Carrot"};

        //call method for addItems
        addItems(veggiesName);
        checkoutItems();

    }

    public static void addItems(String[] veggiesName){

        //create list for h4.product-name
        List<WebElement> vegName = driver.findElements(By.cssSelector("h4.product-name"));

        int j=0;
        for (int a=0; a<=vegName.size(); a++){

            String[] prodName = vegName.get(a).getText().split("-");
            String format = prodName[0].trim();

            int b = a+1;

            //convert array to array list
            List<String> al = Arrays.asList(veggiesName);

            //if the content of al contains to prodname
            if (al.contains(format)){

                j++;
                driver.findElement(By.xpath("//div[@class='products']//div["+b+"]//div[3]//button[1]")).click();
                if(j==veggiesName.length)
                {
                    break;
                }

            }

        }
    }

    public static void checkoutItems(){

        driver.findElement(By.className("cart-icon")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();

        WebDriverWait waitText = new WebDriverWait(driver, Duration.ofSeconds(10));

       waitText.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.promoInfo"))));

       driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();




    }


}
