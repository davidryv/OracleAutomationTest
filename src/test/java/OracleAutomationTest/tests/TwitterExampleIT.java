package OracleAutomationTest.tests;

import OracleAutomationTest.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by david on 23/06/2017.
 */
public class TwitterExampleIT extends DriverBase{


    @Test
    public void TwitterLogInExample() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit twitter
        driver.get("https://twitter.com/");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("https://twitter.com/");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("session[username_or_email]"));

        // Enter username
        element.sendKeys("davidryv");

        //Find the password element by its name

        element.findElement(By.name("session[password]"));

        // Enter password

        element.sendKeys("Wrong Password");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("Login");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    }


}
