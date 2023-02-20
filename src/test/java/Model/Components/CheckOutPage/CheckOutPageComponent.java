package Model.Components.CheckOutPage;

import Utils.ElementConverter;
import Utils.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPageComponent {

    private WebDriver driver;

    @FindBy(css=".input[placeholder$='Select Country']")
    private WebElement inputCountryTextField;

    @FindBy(className = "btnn")
    private WebElement placeOrderButton;

    public CheckOutPageComponent(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public CheckOutPageComponent inputAndSelectSpecificCountry(String inputString, String selectString)
    {
        inputCountryTextField.clear();
        inputCountryTextField.sendKeys(inputString);
        List<WebElement> suggestItems = driver.findElements(By.cssSelector("span.ng-star-inserted"));
        WaitUtility.waitUntilElementIsVisible(this.driver,5, ElementConverter.convertElementToByForPageObject(suggestItems.get(0)));
        suggestItems.stream().filter(s-> s.getText().equalsIgnoreCase(selectString)).forEach(s -> s.click());
        return this;
    }

    public CheckOutPageComponent clickOnPlaceOrderButton()
    {
        this.placeOrderButton.click();
        return this;
    }


}
