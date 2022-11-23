package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {

public static String baseUrl="https://courses.ultimateqa.com/ ";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test

    public void userShouldNavigateToLoginPageSucceessfully(){

        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']//a[normalize-space()='Sign In'] "));
        String expectedMessage="Welcome Back!";
        Assert.assertEquals(expectedMessage,getTextFromElement(By.xpath("//h1[text()='Welcome Back!']")));
    }

    @Test

    public void varifyTheErrorMessage(){

        // Click to login
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']//a[normalize-space()='Sign In'] "));

        // Enter invalid user name
        sendTextToElement(By.id("user[email]"),"vimal");
        // Enter Invalid Password
        sendTextToElement(By.name("user[password]"),"12345vim");
        // Click on sign In
        clickOnElement(By.xpath("//input[@value='Sign in']"));
        // Varify the Sign In
        String expectedMessage="Invalid email or password.";
        Assert.assertEquals(expectedMessage,getTextFromElement(By.xpath("//li[@role='alert']")));


    }
}
