package Demo;

import Demo.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listen implements ITestListener {

    private WebDriver getDriverFromResult(ITestResult result) {
        Object testClassInstance = result.getInstance();
        return ((BaseTest) testClassInstance).driver;
    }

    @Override
    public void onTestStart(ITestResult result){

    }

    @Override
    public void onTestSuccess(ITestResult result){

        WebDriver driver = getDriverFromResult(result);

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("C:/Users/User/Documents/selenium/OnTestSuccess/ss1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onTestFailure(ITestResult result){

        WebDriver driver = getDriverFromResult(result);

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("C:/Users/User/Documents/selenium/OnTestFail/ss1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result){



    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result){

        this.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context){

    }

    @Override
    public void onFinish(ITestContext context){

    }




}
