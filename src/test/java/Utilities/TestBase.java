package Utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public String url="https://www.freecrm.com/";
    public Faker fake;
    public Select select;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        fake = new Faker();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        //driver.quit();
    }
}
