package Test;

import Model.PageObject.LoginPageObject;
import TestFlow.LoginPageTestFlow;
import Utils.DataReader;
import org.testng.annotations.Test;

public class LoginPageTest {

    @Test
    public void testLoginPage()
    {
        String fileName = "\\src\\test\\TestData\\LoginTest";
        LoginPageObject[] loginPageObjects = DataReader.readDataFromJSONFile(fileName,LoginPageObject[].class);
        for (LoginPageObject loginPageObject : loginPageObjects) {
            String email = loginPageObject.getEmail();
            String password = loginPageObject.getPassword();
            LoginPageTestFlow loginPageTestFlow = new LoginPageTestFlow(email,password);
            loginPageTestFlow.performLogin();
        }
    }

}
