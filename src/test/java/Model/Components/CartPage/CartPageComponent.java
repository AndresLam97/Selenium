package Model.Components.CartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPageComponent {

    private WebDriver driver;

    @FindBy(xpath = "//*[@class='infoWrap']")
    private List<WebElement> orderedItems;

    @FindBy(css = "ul[style$='list-style-type: none;']")
    private WebElement checkOutComponents;



    public CartPageComponent(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public List<String> getAllOrderedItemName()
    {
        return orderedItems.stream().map(s->s.findElement(By.tagName("h3")).getText().toLowerCase()).collect(Collectors.toList());
    }

    public CartPageComponent clickOnCheckOutButton() {
        checkOutComponents.findElement(By.tagName("button")).sendKeys(Keys.ENTER);
        return this;
    }

    /*public WebElement checkOutButtonElement()
    {
        for (WebElement checkOutComponent : checkOutComponents) {
            if(checkOutComponent.findElement())
        }
    }*/


}
