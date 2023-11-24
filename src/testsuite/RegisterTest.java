package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }


    @Test
    public void verifyThatSignInPageDisplay() {
        String expectedResult = "Create New Customer Account";
        WebElement account = driver.findElement(By.xpath("//a[text()='Create an Account']"));
        account.click();

        WebElement register = driver.findElement(By.xpath("//span[text()='Create New Customer Account']"));
        String actualResult = register.getText();

        Assert.assertEquals("Not redirected to Login page", expectedResult, actualResult);
    }
@Test
    public void userSholdRegisterAccountSuccessfully()
    {

        String expectedResult = "Thank you for registering with Main Website Store.";
        WebElement account = driver.findElement(By.xpath("//a[text()='Create an Account']"));
        account.click();


        WebElement fName = driver.findElement(By.id("firstname"));
        fName.sendKeys("John");

        WebElement lName = driver.findElement(By.id("lastname"));
        lName.sendKeys("Smith");

        WebElement email = driver.findElement(By.id("email_address"));
        email.sendKeys("abcd@xyz.com");

        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("Pass1234.");

        WebElement confirmPass = driver.findElement(By.id("password-confirmation"));
        confirmPass.sendKeys("Pass1234.");

        WebElement clickCreate = driver.findElement(By.xpath("//span[text()='Create an Account']"));
        clickCreate.click();


        WebElement registerd = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering')]"));
        String actualResult = registerd.getText();

        Assert.assertEquals("Not redirected to Login page", expectedResult, actualResult);



    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
