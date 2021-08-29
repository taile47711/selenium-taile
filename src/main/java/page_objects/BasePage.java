package page_objects;


import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage extends DriverHelper {
    //locator
    private By tabLogin = By.cssSelector("li a[href*='/Account/Login.cshtml']");
    private By tabRegister = By.cssSelector("li a[href='/Account/Register.cshtml']");
    private By tabBookTicket = By.cssSelector("li a[href='/Page/BookTicketPage.cshtml']");
    private By tabTimetable = By.cssSelector("li a[href*='TrainTimeListPage.cshtml']");
    private By tabTicketPrice = By.cssSelector("li a[href*='/Page/TrainPriceListPage.cshtml']");

    //element
    private WebElement getTabLogin() {
        return DriverHelper.getDriver().findElement(tabLogin);
    }

    private WebElement getTabRegister() {
        return DriverHelper.getDriver().findElement(tabRegister);
    }

    private WebElement getTabBookTicket() {
        return DriverHelper.getDriver().findElement(tabBookTicket);
    }

    private WebElement getTabTimetable() {
        return DriverHelper.getDriver().findElement(tabTimetable);
    }

    private WebElement getTabTicketPrice() {
        return DriverHelper.getDriver().findElement(tabTicketPrice);
    }

    //method
    public void clickLoginTab() {
        getTabLogin().click();
    }

    public void clickRegisterTab() {
        getTabRegister().click();
    }

    public void clickBookTicketTab() {
        getTabBookTicket().click();
    }

    public void clickTimetableTab() {
        getTabTimetable().click();
    }

    public void clickTicketPriceTab() {
        getTabTicketPrice().click();
    }
}
