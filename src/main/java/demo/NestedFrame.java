package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrame {
    ChromeDriver driver;

    public NestedFrame() {
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
        // Navigate to URL https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // driver.switchTo() frame top
        driver.switchTo().frame("frame-top");
        // driver.switchTo() frame left Using Locator "Name"
        driver.switchTo().frame("frame-left");
        // getText() for the frame
        String frameLeft = driver.findElement(By.xpath("//*[contains(text(), 'LEFT')]")).getText();
        System.out.println("Left frame text " + frameLeft);
        // driver.switchTo().parent() element.getText()
        driver.switchTo().parentFrame();
        // Locate the element for middle frame Using Locator "Name" frame-middle
        // driver.switchTo() frame middle Using Locator "Name"
        driver.switchTo().frame("frame-middle");
         // getText() for the frame element.getText()
        String frameMiddle = driver.findElement(By.xpath("//*[contains(text(), 'MIDDLE')]")).getText();
        System.out.println("middle frame text " + frameMiddle);
        // driver.switchTo().parent()
        driver.switchTo().parentFrame();
        // Locate the element for right frame Using Locator "Name" frame-right
        // driver.switchTo() frame right Using Locator "Name"
        driver.switchTo().frame("frame-right");
        // getText() for the frame element.getText()
        String frameRight = driver.findElement(By.xpath("//*[contains(text(), 'RIGHT')]")).getText();
        System.out.println("right frame text " + frameRight);
        // driver.switchTo().defaultcontent()
        driver.switchTo().defaultContent();
        // Locate the element for bottom frame Using Locator "Name" frame-bottom
        // driver.switchTo() frame bottom Using Locator "Name"
        driver.switchTo().frame("frame-bottom");
        // getText() for the frame element.getText()
        String frameBottom = driver.findElement(By.xpath("//*[contains(text(), 'BOTTOM')]")).getText();
        System.out.println("Bottom frame text " + frameBottom);
        // driver.switchTo().defaultcontent()
        driver.switchTo().defaultContent();

    }
}