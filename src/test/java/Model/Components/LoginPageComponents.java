package Model.Components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageComponents {
    private WebDriver driver;

    @FindBy(id="userEmail")
    private WebElement emailTextField;

    @FindBy(id="userPassword")
    private WebElement passwordTextField;

    @FindBy(id="login")
    private WebElement loginButton;

    LoginPageComponents(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPageComponents inputEmail(String email)
    {
        this.emailTextField.clear();
        this.emailTextField.sendKeys(email);
        return this;
    }

    public LoginPageComponents inputPassword(String password)
    {
        this.passwordTextField.clear();
        this.passwordTextField.sendKeys(password);
        return this;
    }

    public LoginPageComponents clickOnLoginButton()
    {
        this.loginButton.click();
        return this;
    }
}
