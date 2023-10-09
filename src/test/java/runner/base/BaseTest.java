package runner.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ReportUtils;

import java.lang.reflect.Method;

public abstract class BaseTest {

    private static final String BASE_URL = "https://askomdch.com/";
    protected WebDriver driver;
//    private WebDriverWait wait;
//    private WebDriverWait wait10;
     @BeforeSuite
protected void beforeSuite(ITestContext context) {

    Reporter.log(ReportUtils.getReportHeader(context), true);
}

    @BeforeMethod
    protected void beforeMethod(Method method, ITestResult result) {
        driver = BaseUtils.createDriver();

        Reporter.log(ReportUtils.END_LINE, true);
        Reporter.log("TEST RUN", true);
        Reporter.log(ReportUtils.getClassNameTestName(method, result), true);
    }

//    @BeforeMethod
//    public void beforeMethod() {
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        driver.manage().window().setSize(new Dimension(1920, 1080));
//        driver.get("https://askomdch.com/");
//    }
//    protected void beforeMethod() {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless", "--window-size=1920,1080");
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//    }
//    protected void beforeMethod(Method method) {
//        BaseUtils.logf("Run %s.%s", this.getClass().getName(), method.getName());
//        try {
//            startDriver();
//        } catch (Exception e) {
//            closeDriver();
//            throw new RuntimeException(e);
//        }
//    }
//    protected void startDriver() {
//        BaseUtils.log("Browser open");
//        driver = BaseUtils.createDriver();
//    }
//    protected void closeDriver() {
//        if (driver != null) {
//            driver.quit();
//            BaseUtils.log("Browser closed");
//        }
//    }
    @AfterMethod

    protected void afterMethod(Method method, ITestResult result) {
        Reporter.log(ReportUtils.getTestStatistics(method, result), true);

        driver.quit();
    }
    public static String getBaseUrl() {

        return BASE_URL;
    }
//    public void afterMethod() {
//        driver.quit();
//    }
//    public static String getBaseUrl() {
//
//        return BASE_URL;
//    }
//    protected void afterMethod(Method method, ITestResult testResult) {
//       // stopDriver();
//        BaseUtils.logf("Execution time is %o sec\n\n", (testResult.getEndMillis() - testResult.getStartMillis()) / 1000);
//    }
//  //  protected void afterMethod(){
//        driver.quit();
//    }

    protected WebDriver getDriver() {
        return driver;
    }

//    protected WebDriverWait getWait() {
//        if(wait == null) {
//            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
//        }
//        return wait;
//    }
//    public WebDriverWait getWait10() {
//
//        if (wait10 == null) {
//            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        }
//        return wait10;
//    }

}
