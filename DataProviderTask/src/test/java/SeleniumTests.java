import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class SeleniumTests {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void checkTitle() {
        driver.get("https://www.foxtrot.com.ua");
        String title = driver.getTitle(); ;
        Assert.assertTrue(title.equals("Интернет магазин ФОКСТРОТ | Сеть магазинов бытовой техники и электроники в " +
                "Украине - яркие и свежие как цитрус (citrus) скидки"));
    }

    @Test
    public void checkThatBasketIsEmpty(){
        driver.get("https://avic.ua/");
        String actualCountGoodsInBasket = driver.findElement(By.xpath("//div[contains(@class,'header-bottom__cart')]" +
                        "//div[contains(@class,'cart_count')]"))
                .getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(actualCountGoodsInBasket, "0");

    }

    @Test
    public void checkThatContainsSearchWorld(){
        driver.get("https://avic.ua/");
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("Xiaomi 10");
        driver.findElement(By.xpath("//button[@class='button-reset search-btn']")).click();
        assertTrue(driver.getCurrentUrl().contains("query=Xiaomi"));
    }

    @Test
    public void checkThatDiscountGoodsAreEnable(){
        driver.get("https://avic.ua/");
        driver.findElement(By.xpath("//a[@href=\"/discount\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Уцененные товары!']")).isDisplayed());
    }

    @AfterMethod
    public void finish() {
        driver.close();
        driver.quit();
    }
}
