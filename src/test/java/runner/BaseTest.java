package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverWait wait10;

    @BeforeMethod
    protected void beforeMethod() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod
    protected void afterMethod(){
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        if(wait == null) {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }
        return wait;
    }
    public WebDriverWait getWait10() {

        if (wait10 == null) {
            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }
        return wait10;
    }
}
