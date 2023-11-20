package trellotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
   // String email = "petrkislansky@gmail.com";
   // String password = "Haifa082022$";
    @Test
    public void loginPositive(){

        driver.findElement(By.xpath("//a[contains(@data-uuid, 'login')]"));
        clickBase(By.xpath("//a[contains(@data-uuid, 'login')]"));
        //new page opened, type user's email

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='username']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("petrkislansky@gmail.com");
        //click on submit button , go to the atlassian page
        clickBase(By.xpath("//button[@id='login-submit']"));

       WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Haifa082022$");
        //click submit-login button
        driver.findElement(By.xpath("//button[@id='login-submit']")).click();
        //check that user logged in successfully and there are the elements by locator and text

        String boardText = driver.findElement(By.xpath("//span[text()='Boards']")).getText();

        Assert.assertEquals(boardText, "Boards", "text not Boards");
    }
    /*
    .withEmail("petrkislansky@gmail.com")
                        .withPassword("Haifa082022$");
     */
    @Test
    public void loginPositiveReformat(String email, String password){

            clickBase(By.xpath("//a[contains(@data-uuid, 'login')]"));
            sendKeysBase(By.xpath("//input[@id='username']"), "email");
            clickBase(By.xpath("//button[@id='login-submit']"));
            sendKeysBase(By.xpath("//input[@id='password']"), "password");
            clickBase(By.xpath("//button[@id='login-submit']"));
            String boardText = driver.findElement(By.xpath("//span[text()='Boards']")).getText();
            Assert.assertEquals(boardText, "Boards", "text not Boards");
        }




}
