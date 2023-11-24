package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class SaleTest extends BaseTest {

    static String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
     public void verifyTheTotalItemsDisplayedOnTheWomen() {
        String expectedResult = "Jackets";
        WebElement sale = driver.findElement(By.xpath("//span[text()='Sale']"));
        sale.click();

        WebElement jacket = driver.findElement(By.xpath("//a[text()='Jackets']"));
         jacket.click();

        WebElement findJacket = driver.findElement(By.id("page-title-heading"));
        String actualResult= findJacket.getText();
        Assert.assertEquals("Not redirected to Login page", expectedResult, actualResult);

        if(Objects.equals(actualResult, expectedResult))
        {
            System.out.println("Total Jackets: " + actualResult);
            List<WebElement> allItems = driver.findElements(By.className("product-item-link"));
            for (WebElement product : allItems){
                String prodName =  product.getText();
                System.out.println("Product Name : " + prodName);
           }
        }
     }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
