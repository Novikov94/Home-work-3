import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waiters {

    @Test
    public static void implicitlyWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com.ua");
        driver.findElement(By.name("q")).sendKeys("EPAM");
        driver.findElement(By.name("btnK")).click();

        driver.close();
        driver.quit();
    }

    @Test
    public static void explicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com.ua");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnI")));

        driver.findElement(By.name("q")).sendKeys("EPAM");
        driver.findElement(By.name("btnK")).click();

        driver.close();
        driver.quit();
    }

}
