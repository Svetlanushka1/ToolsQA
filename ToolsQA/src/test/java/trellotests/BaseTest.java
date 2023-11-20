package trellotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver driver ;

    @BeforeSuite(alwaysRun=true)//must launch in any cases
    public void precondition(){
        driver = new ChromeDriver();
        driver.navigate().to("https://trello.com/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       // WebDriverWait wait = new WebDriverWait(driver,5);

    }
    @AfterSuite(alwaysRun = true)
    public void postConditions(){
         // driver.quit();
    }
    public void waitUntilElementIsClickable(By by){
        WebDriverWait wait = new WebDriverWait(driver,5);
       // wait.until(ExpectedConditions.visibilityOf(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }
    public WebElement findElementBase(By by){//finds an element by locator
        return driver.findElement(by);
    }
    public void clickBase(By by){//click on the found element by locator
        waitUntilElementIsClickable(by);
        findElementBase(by).click();
    }
    public  void sendKeysBase(By by, String text){//type the text to the element by locator
        WebElement el = driver.findElement(by);
        el.click();
        el.clear();
        el.sendKeys(text);
    }
}
