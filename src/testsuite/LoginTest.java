package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test

    public void userShouldLoginSuccessfullyWithValid()
    {
        String expectedResult = "Welcome";
        WebElement login = driver.findElement(By.xpath(" //a[contains(text(),'Sign In')]"));
        login.click();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("abcd@xyz.com");

        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("Pass1234.");

        WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
        signIn.click();

        WebElement welcome = driver.findElement(By.xpath("//span[contains(text(),'Welcome')]"));
        String actualResult= welcome.getText();

        if(actualResult.contains(expectedResult))
        {
            Assert.assertEquals("Not redirected to Login page", actualResult, actualResult);
            System.out.println("yyy");
        }

    }

    @Test

    public void verifyTheErrorMessageWithInvalidCredentials()
    {
        String expectedResult = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement login = driver.findElement(By.xpath(" //a[contains(text(),'Sign In')]"));
        login.click();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("abcd@xyz.com");

        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("Pass1234.Wrong");

        WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
        signIn.click();

        WebElement error = driver.findElement(By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']"));
        String actualResult= error.getText();

          Assert.assertEquals("Not redirected to Login page", expectedResult, actualResult);


    }

    @Test
public void userShouldLogOutSuccessfully()
{
    String expectedResult = "You are signed out";
    WebElement login = driver.findElement(By.xpath(" //a[contains(text(),'Sign In')]"));
    login.click();

    WebElement email = driver.findElement(By.id("email"));
    email.sendKeys("abcd@xyz.com");

    WebElement pass = driver.findElement(By.id("pass"));
    pass.sendKeys("Pass1234.");

    WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
    signIn.click();

    WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
    logout.click();

    WebElement logedOutMsg = driver.findElement(By.xpath("//span[text()='You are signed out']"));
    String actualResult=  logedOutMsg.getText();

    Assert.assertEquals("Not redirected to Login page", expectedResult, actualResult);

}
    @After
    public void tearDown() {
        closeBrowser();
    }
}