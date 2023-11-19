package locators_jsExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
public class TableTest {
    // https://www.w3schools.com/css/css_table.asp

    WebDriver driver;
    @BeforeClass
    public void preconditions() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void postConditions() {
        driver.quit();
    }

    @Test
    public void tableTests() {
        List<WebElement> listTr = driver.findElements(By.cssSelector("table#customers tbody tr"));
        // //table[@id='customers']/tbody//tr
        System.out.println(listTr.size() + " tr list size");

        WebElement firstTR = driver.findElement(By.cssSelector("table#customers tbody tr:first-child"));
        //table[@id='customers']/tbody//tr[1]
        WebElement firstTRFirstTh = driver.findElement(By.cssSelector("table#customers tbody tr:first-child th"));
        //table[@id='customers']/tbody//tr[1]/th[1]
        System.out.println("firstTRFirstTh : " + firstTRFirstTh.getText());

        WebElement middleChild =
                driver.findElement(By.cssSelector("table#customers tbody tr:nth-child(3) td:nth-child(2)"));
        //table[@id='customers']/tbody//tr[3]/td[2]
        System.out.println("middle child : " + middleChild.getText());


    }
}