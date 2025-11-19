package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Udemy101 {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        NameSetUp n1 = new NameSetUp();

        // Get screen resolution (manually set these values based on your setup)
        int monitorWidth = 1920;  // Width of a single monitor
        int monitorHeight = 1080; // Height of the monitor

        // Move browser to second monitor (assuming left monitor is primary)
        driver.manage().window().setPosition(new Point(monitorWidth, 0));
        driver.manage().window().setSize(new Dimension(monitorWidth, monitorHeight));
        driver.manage().window().maximize();

        //String ss = n1.getName();

        driver.get("https://pgt-dev-admin.i4projects.net/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("email")).sendKeys(n1.getName());
        driver.findElement(By.id("password")).sendKeys("Pgtjanweirotero@07");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(1000);
        driver.get("https://pgt-dev-admin.i4projects.net/scorecards/draw-arrangement/WzDerGgRx7m0vAmlNMpJ/PGT");

        //check how many div are there in ag-center class
        List<WebElement> divs = driver.findElements(By.cssSelector(".ag-center-cols-container > div"));
        int count = divs.size(); // Get the number of <div> elements

        int max = 6;
        int min = 2;

        for (int x=1; x<=count; x++){

            for(int y=1; y<=21; y++){

                Random rand = new Random();

                //generate numbers between max and min
                int randNum = rand.nextInt(max - min)+1+min;

                driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div["+ x +"]/div["+ y +"]")).sendKeys(String.valueOf(randNum));
             }

        }

        Thread.sleep(1000);
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll up to the top of the page
        js.executeScript("window.scrollTo(0, 0);");

        //Click the save button
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/button[3]")).click();

        //confirm save
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[2]/button[2]")).click();

        //Go to Round 2
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[2]")).click();


        for (int x=1; x<=count; x++){

            for(int y=1; y<=21; y++){

                Random rand = new Random();

                //generate numbers between max and min
                int randNum = rand.nextInt(max - min)+1+min;

                driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div["+ x +"]/div["+ y +"]")).sendKeys(String.valueOf(randNum));
            }

        }

        Thread.sleep(1000);
        // Cast driver to JavascriptExecutor
        JavascriptExecutor js1 = (JavascriptExecutor) driver;

        // Scroll up to the top of the page
        js.executeScript("window.scrollTo(0, 0);");

        //Click the save button
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/button[3]")).click();


        //Go to Round 2
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[2]/div[2]/button[2]")).click();



    }

}
