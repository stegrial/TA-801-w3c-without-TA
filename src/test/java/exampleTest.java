import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class exampleTest {
    private WebDriver driver;
    private By loginBtn = By.cssSelector("a.login-btn");
    private By signupBtn = By.cssSelector("div.sign-up-container > a");
    private By emailFl = By.name("email");


    @BeforeTest
    public void beforeTest() {

        /* Optional, if not specified, WebDriver will search your path for chromedriver.  *
         *    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");      */

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void exampleTest() {
        driver.get("https://trueautomation.io");

        driver.findElement(loginBtn).click();
        driver.findElement(signupBtn).click();

        driver.findElement(emailFl).sendKeys("your@mail.com");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}