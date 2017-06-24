package OracleAutomationTest.tests;

import OracleAutomationTest.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * Created by david on 23/06/2017.
 */
public class TwitterExampleIT extends DriverBase{


    @Test
    public void TwitterLogInExampleFailed() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit twitter
        driver.get("https://twitter.com/");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("https://twitter.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Find the text input element by its name

        WebElement element = driver.findElement(By.id("signin-email"));
        element.click();

        // Enter username
        element.sendKeys("davidryv");

        //Find the password element by its name
        WebElement element2 = driver.findElement(By.id("signin-password"));
        element2.click();
        // Enter password

        element2.sendKeys("Wrong Password");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Twitter webpage is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("login");
            }
        });

        // Should see: "LogIn"
        System.out.println("Page title is: " + driver.getTitle());
    }



    @Test
    public void TwitterLogInExampleSuccess() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit twitter
        driver.get("https://twitter.com/");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("https://twitter.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Find the text input element by its name

        WebElement element = driver.findElement(By.id("signin-email"));
        element.click();

        // Enter username
        element.sendKeys("resonancia_mx");

        //Find the password element by its name
        WebElement element2 = driver.findElement(By.id("signin-password"));
        element2.click();
        // Enter password

        element2.sendKeys("115Te7Gia");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Twitter webpage is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("twitter");
            }
        });

        // Should see: "Twitter Timeline"
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void TwitterLogInExampleForgot() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit twitter
        driver.get("https://twitter.com/account/begin_password_reset");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("https://twitter.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Find the text input element by its name

        WebElement element = driver.findElement(By.xpath("//input[@id='Form-textbox is-required is-validatedRemotely']"));


        // Enter username
        element.sendKeys("resonancia_mx");
        // Summit user
        element.submit();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Summit method of recovery
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Twitter webpage is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("twitter");
            }
        });

        // Should see: "Twitter Timeline"
        System.out.println("Page title is: " + driver.getTitle());
    }


}
