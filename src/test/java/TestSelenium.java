
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class TestSelenium {
    @Test
    public void testSelenium() {
        //Setting properties for chrome web driver for testing
        System.setProperty("webDriver.chrome.driver", "C:\\Users\\Tarun\\Downloads\\chromedriver_win32\\chromedriver.exe");

        //initializing the web driver class
        WebDriver driver  = new ChromeDriver();

        //navigating to url
        driver.navigate().to("http://localhost:3000/home");

        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        JavascriptExecutor javascriptExecutor =  (JavascriptExecutor) driver;
      //  javascriptExecutor.executeScript("scrollBy(0.5000)");

        System.out.println(javascriptExecutor);
        driver.get("http://localhost:3000/login");
        driver.findElement(By.name("username")).sendKeys("harsh");

        driver.findElement(By.name("password")).sendKeys("harsh@1234");

        driver.findElement(By.xpath("//button[@type='submit'][text()='Submit']")).click();

        driver.quit();
    }
}
