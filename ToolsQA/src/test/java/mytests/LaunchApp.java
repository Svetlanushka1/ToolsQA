package mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LaunchApp {
    WebDriver wd;
    String browser;
    @Test
    public void startApp(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("load-extension=C:\\tools\\5.3.2_0");
        wd = new ChromeDriver(options);
        /*

        if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Tests on FIREFOX");
        } else if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Tests on CHROME");
        }*/
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://demoqa.com/");
        //returnToDemoQa();

    }
    private void returnToDemoQa() {
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1)).close();
        wd.switchTo().window(tabs.get(0));
    }
}
