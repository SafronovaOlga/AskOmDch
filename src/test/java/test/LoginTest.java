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




    @Test
    public void testTemperatureInFahrenheit() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://openweathermap.org/";
        String fTempSymbol = "°F";

        driver.get(url);

        WebElement menuImperial = driver.findElement(
                By.xpath("//div[@class = 'switch-container']/div[@class='option']/following-sibling::div")
        );
        menuImperial.click();

        WebElement tempF = driver.findElement(
                By.xpath("//div[@class='current-temp']/span")
        );
        String tempInF = tempF.getText();

        Assert.assertTrue(tempInF.contains(fTempSymbol));

        driver.quit();
    }

//    @Test
//    public void DemoqaTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://demoqa.com/automation-practice-form");
//
//        WebElement textBox = driver.findElement(By.id("firstName"));
//        textBox.sendKeys("Vova");
//
//        WebElement textBox2 = driver.findElement(By.id("lastName"));
//        textBox2.sendKeys("Petrov");
//
//        WebElement tel = driver.findElement(By.id("userNumber"));
//        tel.sendKeys("8800222552");
//
//        WebElement pol = driver.findElement(By.className("custom-control-label"));
//        pol.click();
//
//        WebElement submitButton = driver.findElement(By.id("submit"));
//        submitButton.click();
//
//        WebElement proverka = driver.findElement(By.id("example-modal-sizes-title-lg"));
//        String value = proverka.getText();
//        Assert.assertEquals(value, "Thanks for submitting the form");
//
//        driver.quit();
//    }

}

