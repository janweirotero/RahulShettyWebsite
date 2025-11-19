package Course;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class accessChildWindows {

    public static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://rahulshettyacademy.com/documents-request");
        //driver.findElement(By.xpath("//a[contains(text(),'Free Access to InterviewQues/ResumeAssistance/Material')]")).click();

        //get or record the tabs
        Set<String> windows = driver.getWindowHandles();
        //divide the tabs into parent, child, subchild
        Iterator<String> it = windows.iterator();//[parent,child]
        //next() indicate the windows you are accessing, since 2 next(). it will be the child
        String parentId = it.next();
        String childId = it.next();

        //get the email in the text by split and trim
        driver.switchTo().window(childId);
        String[] text = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at");
        String[] nxtText = text[1].split(" ");
        String trimText = nxtText[1].trim();

        //getting back to the parent tab
        driver.switchTo().window(parentId);

        driver.findElement(By.id("username")).sendKeys(trimText);



    }
}
