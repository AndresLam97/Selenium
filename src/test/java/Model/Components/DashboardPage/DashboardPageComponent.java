package Model.Components.DashboardPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPageComponent {

    private WebDriver driver;

    @FindBy(css=".mb-3")
    private List<WebElement> productList;

    public DashboardPageComponent(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void addProductIntoCart(List<String> productNameList)
    {
        for (WebElement webElement : productList) {
            try{
                String itemNameOnPage = webElement.findElement(By.tagName("b")).getText().toLowerCase();
                if(productNameList.contains(itemNameOnPage))
                {
                    System.out.println(itemNameOnPage);
                    webElement.findElement(By.cssSelector("[style$='float: right;']")).click();
                }
                Thread.sleep(2000);
            }catch(Exception ex)
            {
                System.out.println("[ERROR]");
            }
        }
    }

}
