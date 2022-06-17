import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearchSimpleTest {

    WebDriver webDriver;

    @BeforeClass
    public void setup() {
        webDriver = SetupWebDriver.createWebDriver();
    }

    @Test
    public void simplesTest() throws InterruptedException {

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        webDriver.get("https://www.google.com");
        Thread.sleep(1000);
        WebElement searchField = webDriver.findElement(By.name("q"));
        Thread.sleep(1000);
        searchField.clear();
        searchField.sendKeys("selenium");
        Thread.sleep(1000);

        System.out.println("The title is: " + webDriver.getTitle());
        Thread.sleep(1000);
        searchField.submit();

        Thread.sleep(1000);

        webDriver.close();
    }
}
