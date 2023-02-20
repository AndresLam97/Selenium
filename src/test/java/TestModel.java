import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestModel {
    
    public WebDriver driver;
    
    @FindBy(id="userEmail")
    public WebElement findById;
    
    @FindBy(xpath="//*[@formcontrolname='userEmail']")
    public WebElement findByXPATH;
    
    @FindBy(css="input[formcontrolname$='userEmail']")
    public WebElement findByCssSelector;
    
    @FindBy(className = "ng-invalid")
    public WebElement findByClassName;
    
    @FindBy(tagName="input")
    public WebElement findByTagName;
    
    @FindBy(linkText = "Forgot password?")
    public WebElement findByLinkText;
    
    @FindBy(name="login")
    public WebElement findByName;

    public TestModel(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    
}
