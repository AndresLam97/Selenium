package TestFlow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    private WebDriver driver;

    @BeforeClass
    public WebDriver initDriver() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "src/test/java/Utils/information.properties");
        Properties properties = new Properties();
        properties.load(fis);
        WebDriver driver;
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : properties.getProperty("browser");

        if(browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("safari"))
        {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        else
        {
            throw new IllegalArgumentException("[ERR] Please provide the browser name, the system including edge, chrome, firefox, safari");
        }
        return this.driver;
    }



    @AfterClass
    public void quitDriver()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }

}
