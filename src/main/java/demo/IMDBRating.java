package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDBRating {
        ChromeDriver driver;

        public IMDBRating() {
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
                // Navigate to URL https://www.imdb.com/chart/top
                driver.get("https://www.imdb.com/chart/top");
                // Click on Sort By Rankings option using dropdown Using Locator "XPath"
                // //*[@id='sort-by-selector']
                Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='sort-by-selector']")));
                dropdown.selectByVisibleText("Ranking");
                // getText() for first movie Using Locator "XPath"
                // //ul[@role='presentation']/li/div[2]/div/div/div/a[@href='/title/tt0111161/?ref_=chttp_t_1']/h3
                String highestRatedMovie = driver
                                .findElement(By.xpath(
                                                "//ul[@role='presentation']/li/div[2]/div/div/div/a[@href='/title/tt0111161/?ref_=chttp_t_1']/h3"))
                                .getText();
                // sort the movies by release date using dropdown Using Locator "XPath"
                // //*[@id='sort-by-selector']
                dropdown.selectByVisibleText("Release date");
                // getText() of oldest movie Using Locator "XPath"
                // //ul[@role='presentation']/li[250]/div[2]/div/div/div/a/h3
                String oldestMovie = driver
                                .findElement(By.xpath("//ul[@role='presentation']/li[250]/div[2]/div/div/div/a/h3"))
                                .getText();
                // getText() of newest movie Using Locator "XPath"
                // //ul[@role='presentation']/li/div[2]/div/div/div/a[@href='/title/tt9362722/?ref_=chttp_t_1']/h3
                String newestMovie = driver
                                .findElement(By.xpath(
                                                "//ul[@role='presentation']/li/div[2]/div/div/div/a[@href='/title/tt9362722/?ref_=chttp_t_1']/h3"))
                                .getText();
                // sort the movies by number of ratings using dropdown Using Locator "XPath"
                // //*[@id='sort-by-selector']
                dropdown.selectByVisibleText("Number of ratings");
                // getText() of movie with most user ratings Using Locator "XPath"
                // //ul[@role='presentation']/li/div[2]/div/div/div/a[@href='/title/tt0111161/?ref_=chttp_t_1']/h3
                String userRating = driver
                                .findElement(By.xpath(
                                                "//ul[@role='presentation']/li/div[2]/div/div/div/a[@href='/title/tt0111161/?ref_=chttp_t_1']/h3"))
                                .getText();
                // display size of movies in total Using Locator "XPath"
                // //div[@class='sc-f8c44fe8-0 leyYCk cli-poster-container']
                int totalMovies = driver
                                .findElements(By.xpath("//div[@class='sc-f8c44fe8-0 leyYCk cli-poster-container']"))
                                .size();

                System.out.println("Highest Rated Movie = " + highestRatedMovie);
                System.out.println("Oldest Movie = " + oldestMovie);
                System.out.println("Newest Movie = " + newestMovie);
                System.out.println("Most User Rating = " + userRating);
                System.out.println("Total movies = " + totalMovies);

        }
}