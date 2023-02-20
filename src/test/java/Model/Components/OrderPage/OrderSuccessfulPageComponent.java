package Model.Components.OrderPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessfulPageComponent {

    private WebDriver driver;

    @FindBy(tagName="h1")
    private WebElement orderSuccessfulTextElement;

    public OrderSuccessfulPageComponent(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getOrderSuccessfulText()
    {
        return orderSuccessfulTextElement.getText();
    }

    public WebElement getOrderSuccessfulTextElement(){ return this.orderSuccessfulTextElement;}

}
