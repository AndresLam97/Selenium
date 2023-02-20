package Model.Components.LoginPage;

import io.qameta.allure.Step;
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

    @FindBy(xpath="//*[contains(text(),'*Enter Valid Email')]")
    private WebElement invalidEmailElement;

    @FindBy(css="[role='alertdialog']")
    private WebElement incorrectPasswordElement;

    public LoginPageComponents(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Step("Input email with value: {email}")
    public LoginPageComponents inputEmail(String email)
    {
        this.emailTextField.clear();
        this.emailTextField.sendKeys(email);
        return this;
    }

    @Step("Input password with value: {password}")
    public LoginPageComponents inputPassword(String password)
    {
        this.passwordTextField.clear();
        this.passwordTextField.sendKeys(password);
        return this;
    }

    @Step("Click on login button")
    public LoginPageComponents clickOnLoginButton()
    {
        this.loginButton.click();
        return this;
    }

    public String getInvalidEmailErrorText()
    {
        return this.invalidEmailElement.getText();
    }

    public String getIncorrectPasswordErrorText()
    {
        return this.incorrectPasswordElement.getText();
    }

    public WebElement getInvalidEmailElement(){
        return invalidEmailElement;}

    public WebElement getIncorrectPasswordElement() {
        return incorrectPasswordElement;}

}
