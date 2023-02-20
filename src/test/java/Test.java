import Model.Form.DashboardPageForm;
import Model.Form.LoginPageForm;
import TestFlow.BaseTest;
import Utils.WaitUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        LoginPageForm loginPageForm = new LoginPageForm(driver);
        loginPageForm.getLoginPageComponentsObject().inputEmail("lamankien1997@gmail.com").inputPassword("Andres0909861773").clickOnLoginButton();
        WaitUtility.waitUntilURLToBe(driver,5,"https://rahulshettyacademy.com/client/dashboard/dash");
        List<WebElement> elementList = driver.findElements(By.cssSelector(".mb-3"));
        for (WebElement webElement : elementList) {
            WebElement textElement = webElement.findElement(By.tagName("b"));
            System.out.println(textElement.getText());
        }
        driver.quit();










        /*WebDriver driver = goToLandingPage();
        WebDriverWait waitDriver = new WebDriverWait(driver,Duration.ofSeconds(4));
        List<String> itemList = Arrays.asList("zara coat 3","adidas original","iphone 13 pro");
        SoftAssert softAssert = new SoftAssert();

        // Login
        chromeDriver.findElement(By.cssSelector("[placeholder$='email@example.com']")).sendKeys("lamankien1997@gmail.com");
        chromeDriver.findElement(By.cssSelector("[placeholder$='enter your passsword']")).sendKeys("Andres0909861773");
        chromeDriver.findElement(By.id("login")).click();

        // Add item to cart
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body h5 b")));
        List<WebElement> itemCard = chromeDriver.findElements(By.className("card"));
        itemCard.stream().filter(s-> itemList.contains(s.findElement(By.cssSelector(".card-body h5 b")).getText().toLowerCase()))
                .forEach(s-> {
                    try {
                        Thread.sleep(3000);
                        s.findElement(By.cssSelector(".btn.w-10.rounded")).click();
                    } catch (InterruptedException e) { e.printStackTrace(); }
                    });

        // Go to the order page
        Thread.sleep(3000);
        chromeDriver.findElement(By.cssSelector("[routerlink=\"/dashboard/cart\"]")).click();

        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
        List<WebElement> itemListOnOrderPage = chromeDriver.findElements(By.cssSelector(".cartSection h3"));
        List<String> orderedItemName = itemListOnOrderPage.stream().map(s -> s.getText().toLowerCase()).collect(Collectors.toList());

        softAssert.assertTrue(itemList.equals(orderedItemName));

        softAssert.assertAll();

        Thread.sleep(4000);
        chromeDriver.quit();*/
    }

}
