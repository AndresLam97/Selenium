package Model.Form;

import Model.Components.LoginPageComponents;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class LoginPageForm {

    private WebDriver driver;
    private LoginPageComponents loginPageComponents;

    LoginPageForm(WebDriver driver)
    {
        this.driver = driver;
    }


   /* public WebDriver goToLoginPage()
    {
        //driver.
    }*/

}
