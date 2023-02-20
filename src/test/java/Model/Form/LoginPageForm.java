package Model.Form;

import Model.Components.LoginPage.LoginPageComponents;
import org.openqa.selenium.WebDriver;

public class LoginPageForm {

    private WebDriver driver;

    public LoginPageForm(WebDriver driver)
    {
        this.driver = driver;
    }

    public LoginPageComponents getLoginPageComponentsObject()
    {
        return new LoginPageComponents(this.driver);
    }

    public LoginPageForm goToLoginPage()
    {
        driver.get("https://rahulshettyacademy.com/client");
        return this;
    }

}
