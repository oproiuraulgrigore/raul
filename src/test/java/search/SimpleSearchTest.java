package search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class SimpleSearchTest {

    @Test
    public void simpleSearchWithOneKeyword() {
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);

        System.out.println("Pressed Enter in search field");


        List<WebElement> productNames = driver.findElements(By.cssSelector("h2.product-name > a"));

        System.out.println("Stored " + productNames.size() + " product name");

        for (WebElement productName : productNames) {
            assertThat("Some of the products' names do not contain the searched keyword",
                    productName.getText(), containsString("VASE") );
            
        }


    }


}
