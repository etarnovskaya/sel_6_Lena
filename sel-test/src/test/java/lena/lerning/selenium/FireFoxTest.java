package lena.lerning.selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

/**
 * Created by Lena on 01/05/2017.
 */
public class FireFoxTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void startFF(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 1000);
    }

    @Test
    public void firstTest(){

        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wait.until(titleContains("webdriver"));
    }
    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
