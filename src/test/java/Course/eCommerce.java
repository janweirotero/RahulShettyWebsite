package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class eCommerce {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        driver.findElement(By.id("userEmail")).sendKeys("janweir@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Janweir@1234");
        driver.findElement(By.id("login")).click();

        String[] name = {"ZARA","ADIDAS","IPHONE"};

        List<WebElement> getRow = driver.findElements(By.cssSelector(".mb-3"));

        /*int getRowCount = getRow.size();
            for (int i=0; i<=getRowCount;i++){

                String getName = getRow.get(i).getText();
                    if (getName.contains(name[i])){
                        for(int x=1;x<=3;x++) {
                            driver.findElement(By.xpath("(//button[@class='btn w-10 rounded'])[" + x + "]")).click();
                      }
                }
           }*/

      WebElement newProd =  getRow.stream().filter(product -> product.findElement(By.cssSelector("b"))
              .getText().contains(name[1])).findFirst().orElse(null);
      newProd.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        WebElement popup = driver.findElement(By.xpath("//div[@id='toast-container']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(popup));

        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
        driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[3]")).click();

        driver.findElement(By.xpath("(//input[@class=\"input txt text-validated\"])[2]")).sendKeys("ind");

        //List<WebElement> autoSuggest = driver.findElements(By.xpath("//i[@class='fa fa-search']"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-search']")));
        driver.findElement(By.xpath("//body//app-root//button[2]")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();

       String lastPage = driver.findElement(By.xpath("//h1[normalize-space()='Thankyou for the order.']")).getText();
        Assert.assertTrue(lastPage.equalsIgnoreCase("Thankyou for the order."));
        driver.quit();






    }
}
