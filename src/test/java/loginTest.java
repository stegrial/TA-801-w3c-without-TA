import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class loginTest {
    private WebDriver driver;
    private By email = By.xpath("//*[@placeholder='email']");
    private By password = By.xpath("//*[@type='password']");
    private By checkBox = By.id("checkboxG1");
    private By authorize = By.xpath("//*[@class='btn-radius']");

    @BeforeTest
    public void beforeTest() {

        // Optional, if not specified, WebDriver will search your path for chromedriver.
      /*  System.setProperty("webdriver.chrome.driver",
                "/Users/eugeneshapovalov/.chromedriver-helper/2.37/mac/chromedriver"); */

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() {

        /* Navigate on test page */
        driver.get("http://www.trueautomation-demo.inf.ua");

        /* Fill user identifier Id and password */
        driver.findElement(email).sendKeys("team@trueautomation.io");
        driver.findElement(password).sendKeys("password");

        /* Select `Remember me` checkbox */
        driver.findElement(checkBox).click();

        /* Click authorize button */
        driver.findElement(authorize).click();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}