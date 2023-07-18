package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchAmazon {
    ChromeDriver driver;

    public SearchAmazon() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        // navigate to URL google.com
        driver.get("https://www.google.com/");
        // click on search area Using Locator "ID" APjFqb
        WebElement searchbox = driver.findElement(By.id("APjFqb"));
        // Send keys -"amazon" Using Locator "ID" APjFqb
        searchbox.sendKeys("amazon");
        // click on google search button Using Locator "Class" Name gNO89b
        searchbox.sendKeys(Keys.ENTER);
        // Validate text amazon.in present Using Locator "XPath"
        // xpath///a[@href='https://www.amazon.in/']
        WebElement result = driver.findElement(By.xpath("//a[@href='https://www.amazon.in/']"));
        if (result.isDisplayed())
            System.out.println("Amazon link is present");
        else
            System.out.println("Amazon link not present");

    }
}