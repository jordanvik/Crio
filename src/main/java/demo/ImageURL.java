package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageURL {
    ChromeDriver driver;
    String url;

    public ImageURL() {
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

    public void testCase01() throws InterruptedException {
        // Navigate to URL https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(2000);
        // Click on the See All button for recommended movies Using Locator "XPath"
        // //div[text()='See All ›']
        WebElement seeall = driver.findElement(By.xpath("//div[text()='See All ›']"));
        seeall.click();
        Thread.sleep(3000);
        // Get list of URL's Using Locator "Tag Name" img
        List<WebElement> URLlist = driver.findElements(By.tagName("a"));
        int numberofURL = URLlist.size();
        System.out.println("Number of images on page " + numberofURL);
        // Print URL's System out print ln
        for (int i = 0; i < numberofURL; i++) {
            System.out.println("Link:--> " + (URLlist.get(i)).getAttribute("href"));
        }

        // getText() for the second movie name under premieres list Using Locator
        // "XPath"
        // //h2[text()='Premieres']/parent::div/parent::div/parent::div/following-sibling::div/div//div[2]//div[3]/div/div
        driver.navigate().back();
        WebElement premiere = driver
                .findElement(By.xpath("//h2[contains(text(),'Premieres')]/following::a[2]//div/div[3]/div[1]"));
        String secondmovname = premiere.getText();
        // print text in movie name System out print ln
        System.out.println("Second movie name " + secondmovname);
        // getText() for the second movie language under premieres list Using Locator
        // "XPath"
        // //h2[text()='Premieres']/parent::div/parent::div/parent::div/following-sibling::div/div//div[2]//div[3]//div[2]/div
        WebElement lang = driver
                .findElement(By.xpath("//h2[contains(text(),'Premieres')]/following::a[2]//div/div[3]/div[2]"));
        // print text in movie language System out print ln
        String langtext = lang.getText();
        System.out.println("Second movie language" + langtext);
    }
}
