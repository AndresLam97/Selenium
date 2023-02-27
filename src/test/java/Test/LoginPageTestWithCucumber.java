package Test;

import Model.Components.LoginPage.LoginPageComponents;
import Model.Form.LoginPageForm;
import TestFlow.BaseTest;
import TestFlow.LoginPageTestFlow;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginPageTestWithCucumber extends BaseTest {

    LoginPageForm loginPageForm;
    LoginPageComponents loginPageComponents;
    LoginPageTestFlow loginPageTestFlow;
    WebDriver driver;

    @Given("^I landed to the web login page$")
    public void i_landed_to_the_web_login_page()
    {
        initDriverSession();
        this.driver = getDriver();
        loginPageForm = new LoginPageForm(this.driver);
        loginPageForm.goToLoginPage();
    }

    @When("^I perform login with input (.+) and (.+)$")
    public void i_perform_login_with_input_email_and_password(String email, String password)
    {
        loginPageComponents = new LoginPageComponents(this.driver).inputEmail(email).inputPassword(password).clickOnLoginButton();
        loginPageTestFlow = new LoginPageTestFlow(this.driver,email,password);
    }

    @Then("^The page validate and display error$")
    public void the_page_validate_and_display_error()
    {
        loginPageTestFlow.validateData(loginPageComponents);
    }

    @When("^I input the correct (.+) and (.+) to perform login$")
    public void perform_login_with_correct_email_and_password(String email, String password)
    {
        loginPageComponents = new LoginPageComponents(this.driver).inputEmail(email).inputPassword(password).clickOnLoginButton();
        loginPageTestFlow = new LoginPageTestFlow(this.driver,email,password);
    }

    @Then("^the page validate and switches to the dashboard page$")
    public void the_page_validate_and_switches_to_the_dashboard_page()
    {
        loginPageTestFlow.validateData(loginPageComponents);
    }

}
