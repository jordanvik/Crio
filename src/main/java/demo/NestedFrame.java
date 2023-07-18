package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrame {
   ChromeDriver driver;


    public NestedFrame()
    {
    System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        // Navigate to URL  https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Locate the element for top frame  Using Locator "Name" frame-top
        WebElement top = driver.findElement(By.name("frame-top"));
        // driver.switchTo() frame top  
        driver.switchTo().frame(top);
        // Locate the element for left frame Using Locator "Name" Frame-left
        WebElement left = driver.findElement(By.name("frame-left"));
        // driver.switchTo() frame left Using Locator "Name" 
        driver.switchTo().frame(left);
        // getText() for the frame  
        String leftframetxt = left.getText();
        System.out.println("Left frame text" + leftframetxt);
        // driver.switchTo().parent()  element.getText()
        driver.switchTo().parentFrame();
        // Locate the element for middle frame  Using Locator "Name" frame-middle
        WebElement middle = driver.findElement(By.name("frame-middle"));
        // driver.switchTo() frame middle Using Locator "Name" 
        driver.switchTo().frame(middle);
        // getText() for the frame  element.getText()
        String middleframetxt = middle.getText();
        System.out.println("middle frame text" + middleframetxt);
        // driver.switchTo().parent()  
        driver.switchTo().parentFrame();
        // Locate the element for right frame  Using Locator "Name" frame-right
        WebElement right = driver.findElement(By.name("frame-right"));
        // driver.switchTo() frame right Using Locator "Name" 
        driver.switchTo().frame(right);
        // getText() for the frame  element.getText()
        String rightframetxt = right.getText();
        System.out.println("right frame text" + rightframetxt);
        // driver.switchTo().defaultcontent()  
        driver.switchTo().defaultContent();
        // Locate the element for bottom frame  Using Locator "Name" frame-bottom
        WebElement bottom = driver.findElement(By.name("frame-bottom"));
        // driver.switchTo() frame bottom Using Locator "Name" 
        driver.switchTo().frame(bottom);
        // getText() for the frame  element.getText()
        String bottomframetxt = bottom.getText();
        System.out.println("Bottom frame text" + bottomframetxt);
        // driver.switchTo().defaultcontent()  
        driver.switchTo().defaultContent();

    }
}