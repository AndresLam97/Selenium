package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;

    public DriverFactory() { }

    public WebDriver initDriver(String browser) {
        try
        {
            if(browser.equalsIgnoreCase("edge"))
            {
                WebDriverManager.edgedriver().setup();
                this.driver = new EdgeDriver();
            }
            else if(browser.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
            }
            else if(browser.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
            }
            else if(browser.equalsIgnoreCase("safari"))
            {
                WebDriverManager.safaridriver().setup();
                this.driver = new SafariDriver();
            }
            else
            {
                throw new IllegalArgumentException("[ERR] Please provide the browser name, the system including edge, chrome, firefox, safari");
            }
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return this.driver;
    }

    public void closeSession()
    {
        if(this.driver != null)
        {
            this.driver.quit();
        }
    }

}
