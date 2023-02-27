package TestFlow;

import Model.Components.LoginPage.LoginPageComponents;
import Model.Form.LoginPageForm;
import Utils.ElementConverter;
import Utils.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPageTestFlow{

    private String email;
    private String password;
    private static WebDriver driver;

    public LoginPageTestFlow(WebDriver driver, String email, String password)
    {
        this.driver = driver;
        this.email = email;
        this.password = password;
    }

    public LoginPageTestFlow(WebDriver driver)
    {
        this.driver = driver;
    }

    public void performLogin()
    {
        LoginPageForm loginPageForm = new LoginPageForm(driver);
        loginPageForm.goToLoginPage();
        LoginPageComponents loginPageComponents = loginPageForm.getLoginPageComponentsObject();
        loginPageComponents.inputEmail(email);
        loginPageComponents.inputPassword(password);
        loginPageComponents.clickOnLoginButton();
        //validateData(loginPageComponents);
    }


    public void validateData(LoginPageComponents loginPageComponents)
    {
        boolean emailValid = validateEmail(this.email);
        boolean passwordValid = validatePassword(this.password);

        if(!emailValid)
        {
            verifyIncorrectEmail(loginPageComponents);
        }
        else if(!passwordValid)
        {
            verifyIncorrectPassword(loginPageComponents);
        }
        else if(emailValid && passwordValid)
        {
            verifyCorrectEmailAndPassword(loginPageComponents);
        }
    }

    public boolean validateEmail(String email)
    {
        String regex = ".*@.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches())
        {
            return true;
        }
        return false;
    }

    private boolean validatePassword(String password)
    {
        return password.length() > 3;
    }

    private void verifyIncorrectEmail(LoginPageComponents loginPageComponents)
    {
        String expectedResult = "*Enter Valid Email";
        WaitUtility.waitUntilElementIsVisible(driver,4, ElementConverter.convertElementToByForPageObject(loginPageComponents.getInvalidEmailElement()));
        String actualResult = loginPageComponents.getInvalidEmailErrorText();
        Assert.assertEquals(expectedResult,actualResult, "The actual message is not match with expected message");
    }

    private void verifyIncorrectPassword(LoginPageComponents loginPageComponents)
    {
        String expectedResult = "Incorrect email or password.";
        WaitUtility.waitUntilElementIsVisible(driver,4,ElementConverter.convertElementToByForPageObject(loginPageComponents.getIncorrectPasswordElement()));
        String actualResult = loginPageComponents.getIncorrectPasswordErrorText();
        Assert.assertEquals(expectedResult,actualResult,"The actual message is not match with expected message");
    }

    private void verifyCorrectEmailAndPassword(LoginPageComponents loginPageComponents)
    {
        String expectedURL = "https://rahulshettyacademy.com/client/dashboard/dash";
        WaitUtility.waitUntilURLToBe(driver,4,expectedURL);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL, "The actual url is not match with expected url !!!");
    }

    public void setPassword(String password)
    {this.password = password;}

    public void setEmail(String email)
    { this.email = email;}



}
