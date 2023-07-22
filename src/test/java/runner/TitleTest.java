package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class TitleTest extends BaseTest{

    @Test
    public void testCheckSiteTitle(){
        getDriver().get("https://askomdch.com/");
        Assert.assertEquals(getDriver().getTitle(), "AskOmDch – Become a Selenium automation expert!");
        getDriver().quit();
    }

    @Test
    public void testCheckSale() {
        List<WebElement> listFeaturedProducts = getDriver().findElements(By.className("astra-shop-thumbnail-wrap"));
        List<WebElement> listFeaturedProductsText = getDriver().findElements(By.className("astra-shop-summary-wrap"));
        for (int i = 0; i < listFeaturedProductsText.size(); i++) {
            String[] arrProductText = listFeaturedProductsText.get(i).getText().split("\n");
            if (arrProductText[2].split(" ").length > 1) {
                Assert.assertEquals(listFeaturedProducts.get(i).getText(), "Sale!");
            }
        }
    }

    @Test
    public void testVerifySaleIcon() {
        List<WebElement> saleIcons = getDriver().findElements(By.xpath(".//span[text() = 'Sale!']"));
        for (WebElement webElement : saleIcons)
            Assert.assertTrue(webElement.isDisplayed());
    }

    @Test
    public void Test_TC_001_33() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://askomdch.com/");
            WebElement featuredProducts = driver
                    .findElement(By.xpath("//*[contains(text(),'Featured Products')]"));
            List<WebElement> saleProducts = featuredProducts
                    .findElements(By.xpath("//li[contains(@class, 'ast-article-single')]" +
                            "[count(.//span[contains(@class, 'woocommerce-Price-currencySymbol')]) > 1]"));
            for (WebElement saleProduct : saleProducts) {
                assertTrue(saleProduct.findElement(By.cssSelector("span.onsale"))
                        .isDisplayed(), "Sale icon not found on a sale product: " + saleProduct.getText());
            }
        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

//    @Test
//    public void testVerifyNumberOfProduct() {
//        getDriver().findElement(By.xpath("//li[@id='menu-item-1229']/a")).click();
//
//        List<WebElement> womenProducts = getDriver().findElements(By.xpath("//div[@class='astra-shop-thumbnail-wrap']"));
//        Assert.assertEquals(womenProducts.size(), 7);
//    }

//    @Test
//    public void testCheckContactUs() {
//        getDriver().findElement(By.xpath("//div[@class ='wp-block-button is-style-fill']")).click();
//        String textContact  = getDriver().findElement(By.xpath("//h1[@class ='has-text-align-center']")).getText();
//
//        Assert.assertEquals(textContact,"Contact Us");
//    }


//    @Test
//    public void testOpenShop() {
//        getDriver().findElement(By.xpath("//a[@class='wp-block-button__link']")).click();
//        String text = getDriver().findElement(By.xpath("//h1[@class='woocommerce-products-header__title page-title']")).getText();
//
//        Assert.assertEquals(text,"Store");
//    }

}
