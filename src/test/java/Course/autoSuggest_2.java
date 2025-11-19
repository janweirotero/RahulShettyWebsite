package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class autoSuggest_2 {

    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.ikea.com/sg/en/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String wordSearch = "chop";

        WebElement word = driver.findElement(By.id("ikea-search-input"));
        word.sendKeys(wordSearch);

        //use to count how many elements are there in class universal-item
        //ArrayList<WebElement> nem = new ArrayList<>(driver.findElements(By.cssSelector(".universal-item")));
        List<WebElement> nem = driver.findElements(By.cssSelector("li[class='universal-item'] a"));


          for (WebElement nems : nem){

            String newWord = nems.getText();

            if (newWord.equals("chopsticks")){

                //Thread.sleep(5000);

                driver.findElement(By.cssSelector("a[aria-label='"+newWord+"'] span[class='universal-item__title with-autocomplete-icon']")).click();
            }


       }
    }
}
