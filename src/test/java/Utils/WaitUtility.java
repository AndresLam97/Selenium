package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

    public static void waitUntilElementIsVisible(WebDriver driver, int timeout, By elementBy)
    {
        WebDriverWait waitDriver = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public static void waitUntilURLToBe(WebDriver driver, int timeout, String url)
    {
        WebDriverWait waitDriver = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        waitDriver.until(ExpectedConditions.urlToBe(url));
    }

    public static void waitUntilURLContains(WebDriver driver,int timeout, String url){
        WebDriverWait waitDriver = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        waitDriver.until(ExpectedConditions.urlContains(url));
    }
}
