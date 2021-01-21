package uk.co.zoro.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;

    public DriverManager()
    {
        PageFactory.initElements(driver,this);
    }

    public void invokeBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void goToUrl()
    {
        driver.get("https://www.zoro.co.uk/");
    }

    public void maxBrowser()
    {
        driver.manage().window().maximize();
    }

    public void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void quitBrowser()
    {
        driver.quit();
    }
}
