package demo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedPost {

    ChromeDriver driver;

    public LinkedPost()
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

    
    public  void testCase01() throws InterruptedException{
// Navigate to URL  https://in.linkedin.com/
driver.get("https://in.linkedin.com/");
// click on email or phone field Using Locator "ID" session_key
WebElement emailphone = driver.findElement(By.id("session_key"));
// send keys Using Locator "ID" session_key/xyz@gmail.com
emailphone.sendKeys("xyz@gmail.com");
// click on password field Using Locator "ID" session_password
WebElement password = driver.findElement(By.id("session_password"));
// send keys Using Locator "ID" session_password/12345678
password.sendKeys("12345678");
// click on Sign in button Using Locator "XPath" //button[contains(text(), 'Sign in')]
WebElement SignIn = driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]"));
SignIn.click();
Thread.sleep(5000);
WebElement messagebutton = driver.findElement(By.xpath("//div[@class='msg-overlay-bubble-header__controls display-flex']/button[2]"));
messagebutton.click();
// click on start a post Using Locator "XPath" //button[@id='ember25']/span
WebElement startpost = driver.findElement(By.xpath("//span[text()='Start a post']"));
startpost.click();
// click on button post to anyone Using Locator "XPath" //button[@class='share-unified-settings-entry-button']
WebElement postanyone = driver.findElement(By.xpath("//button[@class='share-unified-settings-entry-button']"));
postanyone.click();
// click on Connections only Using Locator "XPath" //button[@id='CONNECTIONS_ONLY']
WebElement connectiononly = driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']"));
connectiononly.click();
// Click on Done button Using Locator "XPath" //span[text()='Done']
WebElement donebutton = driver.findElement(By.xpath("//span[text()='Done']"));
donebutton.click();
// click on typing area  Using Locator "XPath" //div[@class='ql-editor ql-blank']
WebElement typearea = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
// send keys Using Locator "XPath" //div[@class='ql-editor ql-blank']/This is a test post
typearea.sendKeys("This is a test post");
// Click on Post button Using Locator "XPath" //span[text()='Post']
WebElement postbutton = driver.findElement(By.xpath("//span[text()='Post']"));
postbutton.click();
// Click on Who's viewed your profile Using Locator "XPath" //a[@href='/me/profile-views/']
WebElement views = driver.findElement(By.xpath("//a[@href='/dashboard/']"));
views.click();
// get text of element displaying the number of views Using Locator "XPath" //p[@class='text-body-medium-bold pr1 text-heading-large']
WebElement numberofviews = driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/me/profile-views']//div[@class='pcd-analytics-view-item']//p"));
String numviews = numberofviews.getText();
System.out.println("Number of views " + numviews);

// Click on Impressions of your post Using Locator "XPath" //a[@href='/in/vikram-singh-037305126/recent-activity/shares/']
WebElement impressions = driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/analytics/creator/content?timeRange=past_7_days&dimension=INDUSTRY&metricType=IMPRESSIONS']//div[@class='pcd-analytics-view-item']//p"));
// get text of element displaying impressions Using Locator "XPath" //span[@class='ca-entry-point__num-views t-14']
String impressview = impressions.getText();
System.out.println("Number of impression views " + impressview);
       
    }

}