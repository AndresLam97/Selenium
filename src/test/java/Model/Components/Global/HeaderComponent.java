package Model.Components.Global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent {

    private WebDriver driver;
    @FindBy(css=".left")
    private WebElement logoElement;

    @FindBy(css=".btn[routerlink$='/dashboard/']")
    private WebElement homeElement;

    @FindBy(css=".btn[routerlink$='/dashboard/myorders']")
    private WebElement orderElement;

    @FindBy(css=".btn[routerlink$='/dashboard/cart']")
    private WebElement cartElement;

    @FindBy(css=".fa.fa-sign-out")
    private WebElement signOutElement;

    public HeaderComponent(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public HeaderComponent clickOnLogoButton() {
        logoElement.click();
        return this;
    }

    public HeaderComponent clickOnHomeButton()
    {
        homeElement.click();
        return this;
    }

    public HeaderComponent clickOnOrderButton()
    {
        orderElement.click();
        return this;
    }

    public HeaderComponent clickOnCartButton()
    {
        cartElement.click();
        return this;
    }

    public HeaderComponent clickOnSignOutButton()
    {
        signOutElement.click();
        return this;
    }

}
