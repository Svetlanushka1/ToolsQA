package locatorsjsexecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
public class CSS_TagName_Locators {

        WebDriver driver;
        @BeforeClass
        public void preconditions() {
            driver = new ChromeDriver();
            driver.navigate().to("https://demoqa.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @AfterClass
        public void postConditions() {
            driver.quit();
        }

        @Test
        public void testSelectors() {
            driver.findElement(By.cssSelector("h5")); // get by tag h5
            driver.findElement(By.cssSelector(".card-body")); // . -> == search by attribute with the name class
            driver.findElement(By.cssSelector("#close-fixedban")); // . -> == search by attribute with the name id
            driver.findElement(By.cssSelector("[href='/favicon.png']"));
            driver.findElement(By.cssSelector("[href*='favic']")); // with * if contains value
            driver.findElement(By.cssSelector("img.banner-image[src*='ima']"));
            // tag img AND class banner-image AND scr attr contains value ima

            driver.findElement(By.className("card-body"));
            driver.findElement(By.id("close-fixedban"));
            driver.findElement(By.tagName("h5"));
            //driver.findElement(By.name());

        }
    }
