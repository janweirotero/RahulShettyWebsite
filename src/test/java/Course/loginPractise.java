package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class loginPractise {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");

        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

        //wait for the okay button to show
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='okayBtn']")))).click();

        //select the Consultant in dropdown
        WebElement formSel = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select selType = new Select(formSel);
        selType.selectByIndex(2);

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

        selectItems();

    }

    public static void selectItems(){

       /* String[] ItemName = {"iphone","Samsung","Nokia","Blackberry"};

        //get the element into list
        List<WebElement> cartItems = driver.findElements(By.cssSelector("h4.card-title"));
        //count how many elements are there in cartItems
        int i = cartItems.size(), num = 0;

       for (int j=0; j<=cartItems.size(); j++){

           //split the words in cartItems
            String[] newName = cartItems.get(j).getText().split(" ");
            //remove the characters before and after in index 0
            newName[0].trim();

            //make a list in ItemName
            List al = Arrays.asList(ItemName);

            //check if al contains words in newname
            if (al.contains(newName[0])){
                num++;
                driver.findElement(By.xpath("(//button[@class='btn btn-info'])["+num+"]")).click();

                if (num==4){
                    break;
                }

            }

        }*/

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));

        List <WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));

        for(int i =0;i<products.size();i++)

        {

            //get means, getting the index
            products.get(i).click();

        }

       driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
       driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();


    }
}
