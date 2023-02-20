package Test;

import Model.Components.CartPage.CartPageComponent;
import Model.Components.CheckOutPage.CheckOutPageComponent;
import Model.Components.OrderPage.OrderSuccessfulPageComponent;
import Model.Form.DashboardPageForm;
import Model.Form.LoginPageForm;
import TestFlow.BaseTest;
import Utils.ElementConverter;
import Utils.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuyItemTest extends BaseTest {

    @Test
    public void testBuyItemSuccessful()
    {
        WebDriver driver = getDriver();
        List<String> itemList = Arrays.asList("zara coat 3","adidas original");
        LoginPageForm loginPageForm = new LoginPageForm(driver);
        loginPageForm.goToLoginPage();
        loginPageForm.getLoginPageComponentsObject().inputEmail("lamankien1997@gmail.com").inputPassword("Andres0909861773").clickOnLoginButton();
        WaitUtility.waitUntilURLToBe(driver,5,"https://rahulshettyacademy.com/client/dashboard/dash");
        DashboardPageForm dashboardPageForm = new DashboardPageForm(driver);
        dashboardPageForm.getDashboardPageComponent().addProductIntoCart(itemList);
        dashboardPageForm.getHeaderComponent().clickOnCartButton();
        WaitUtility.waitUntilURLToBe(driver,5,"https://rahulshettyacademy.com/client/dashboard/cart");
        CartPageComponent cartPageComponent = new CartPageComponent(driver);
        Assert.assertEquals(itemList, cartPageComponent.getAllOrderedItemName());
        cartPageComponent.clickOnCheckOutButton();
        WaitUtility.waitUntilURLContains(driver,5,"https://rahulshettyacademy.com/client/dashboard/order");
        CheckOutPageComponent checkOutPageComponent = new CheckOutPageComponent(driver);
        checkOutPageComponent.inputAndSelectSpecificCountry("vie","Vietnam").clickOnPlaceOrderButton();
        WaitUtility.waitUntilURLContains(driver,5,"https://rahulshettyacademy.com/client/dashboard/thanks");
        OrderSuccessfulPageComponent orderSuccessfulPageComponent = new OrderSuccessfulPageComponent(driver);
        Assert.assertEquals("THANKYOU FOR THE ORDER.",orderSuccessfulPageComponent.getOrderSuccessfulText());
    }


}
