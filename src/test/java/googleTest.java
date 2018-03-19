import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class googleTest {
    private WebDriver driver;
    private By searchField = By.name("q");
    private By searchBtn = By.name("btnK");

    @BeforeTest
    public void beforeTest() {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver",
                "/Users/eugeneshapovalov/.chromedriver-helper/2.37/mac/chromedriver");

        driver = new ChromeDriver();
    }

    @Test
    public void testEasy() {
        driver.get("https://www.google.com");

        driver.findElement(searchField).sendKeys("Hello Google!");
        driver.findElement(searchBtn).click();

        assertTrue(driver.getTitle().contains("Hello Google!"));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}