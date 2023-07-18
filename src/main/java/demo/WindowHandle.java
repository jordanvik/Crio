package demo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
    ChromeDriver driver;

    public WindowHandle() {
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
        // Navigate to URL
        // https://www.w3schools.com/jsref/tryit.aspfilename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.aspfilename=tryjsref_win_open");
        // switchTo() to iframe Using Locator "ID" iframeResult
        driver.switchTo().frame("iframeResult");
        // Click on button for Try it Using Locator "XPath" //button[text()='Try it']
        WebElement Tryitbutt = driver.findElement(By.xpath("//button[text()='Try it']"));
        Tryitbutt.click();
        // get window handle of main window using driver.getWindowHandle()
        String MainWindow = driver.getWindowHandle();
        // handle all new opened window using driver.getWindowHandles()
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                String title = driver.getTitle();
                System.out.println("Title of the current window " + title);
                String URL = driver.getCurrentUrl();
                System.out.println("Current URL " + URL);
                driver.close();
            }
            driver.switchTo().window(MainWindow);
        }
        // Iterate through windows and switch to child window using
        // driver.switchTo().window(ChildWindow)
        // get the title of the window using driver.getTitle()
        // get the currentURL of the webpage using driver.getCurrentURL()
        // Take screenshot
        // close the child window using driver.close()
        // Switch back to main window using driver.switchTo().window(MainWindow)
    }
}