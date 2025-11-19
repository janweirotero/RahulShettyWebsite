package Demo.base;

import Demo.pageobj.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver  driver;
    public LandingPage landObj;

    public void initializedBrowser() throws IOException {

        //select what browser will run if indicated in globalproperties file
        Properties prop = new Properties();
        //select the value set
        FileInputStream fis = new FileInputStream("C:\\Users\\User\\IdeaProjects\\Udemy\\src\\test\\java\\Demo\\base\\GlobalProperties");
        prop.load(fis);
        //get what is the value in GlobalProperties
        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage runCode() throws IOException {

        initializedBrowser();
        landObj = new LandingPage(driver);
        landObj.goTo();

        return landObj;
    }


    @AfterMethod(alwaysRun = true)
    public void closeThis(){

        driver.quit();
    }


}
