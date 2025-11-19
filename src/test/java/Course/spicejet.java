package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class spicejet {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");
        driver.findElement(By.xpath("//div[contains(text(),'one way')]")).click();
        driver.findElement(By.xpath("//input[@value='Delhi (DEL)']")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'BKK')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(text(),'IXA')]")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-156aje7 r-y47klf r-1phboty r-1d6rzhh r-1pi2tsx r-1777fci r-13qz1uu']")).click();

        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[5]")).click();
        for (int a = 1; a <= 4; a++){

            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj r-d9fdf6']//div[1]//div[2]//div[3]")).click();
        }
        driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[5]")).click();


        driver.findElement(By.xpath("//div[contains(text(),'Family & Friends')]")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("rect[width='100%']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1tazni7 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5']")).click();
    }
}

