package Model.Form;

import Model.Components.DashboardPage.DashboardPageComponent;
import Model.Components.DashboardPage.SearchMenu;
import Model.Components.Global.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class DashboardPageForm {

    private WebDriver driver;
    private HeaderComponent headerComponent;
    private SearchMenu searchMenu;
    private DashboardPageComponent dashboardPageComponent;

    public DashboardPageForm(WebDriver driver)
    {
        this.driver = driver;
        this.headerComponent = new HeaderComponent(driver);
        this.searchMenu = new SearchMenu();
        this.dashboardPageComponent = new DashboardPageComponent(driver);
        PageFactory.initElements(driver,this);
    }

    public DashboardPageComponent getDashboardPageComponent() { return this.dashboardPageComponent;}

    public HeaderComponent getHeaderComponent() { return this.headerComponent; }

    public SearchMenu getSearchMenu() { return this.searchMenu; }

}
