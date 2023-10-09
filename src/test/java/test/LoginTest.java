package test;

import org.openqa.selenium.chrome.ChromeDriver;
import runner.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LoginTest extends BaseTest {

//    @Test
//    public void testVerifyLoginPageOpened() {
//        WebElement accountButton = getDriver().findElement(By.linkText("Account"));
//        accountButton.click();
//        Assert.assertEquals(getDriver().getCurrentUrl(), "https://askomdch.com/account/");
//        WebElement accountPageTitle = getDriver().findElement(
//                By.xpath("//div[@id='primary']//h1[text() = 'Account']"));
//        Assert.assertTrue(accountPageTitle.isDisplayed());
//    }

    @Test
    public void test_006() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://askomdch.com/");

        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        Thread.sleep(1000);

        String textBox = driver.findElement(By.xpath("//h2[@class='has-text-align-center']")).getText();
        Thread.sleep(500);

        Assert.assertEquals(textBox, "Featured Products");

        List<WebElement> products = driver.findElements(By.className("type-product"));
        Assert.assertEquals(products.size(), 5);
        //driver.findElement(By.xpath("//li[@class='ast-article-single product type-product post-1215 status-publish first instock product_cat-men product_cat-womens-shoes has-post-thumbnail featured taxable shipping-taxable purchasable product-type-simple']"));
        driver.quit();
    }
    @Test
    public void titleOfTheHomePageCheckedTest() {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
//        (chromeOptions);  для CI in GITHUB нашего проекта
        
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.get("https://askomdch.com/");

        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");

        driver.findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
        WebElement icon = driver.findElement(By.xpath("//span[@class='onsale']"));

        Assert.assertEquals(icon.getText(), "Sale!");
        driver.quit();
    }

}

