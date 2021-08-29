package page_objects;

import helpers.DateHelper;
import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BookTicketPage extends BasePage {
    //locator
    private final By drpDepartDate = By.cssSelector("select[name='Date']");
    private final By drpDepartFrom = By.cssSelector("select[name='DepartStation']");
    private final By drpArriveAt = By.cssSelector("select[name='ArriveStation']");
    private final By drpSeatAt = By.cssSelector("select[name='SeatType']");
    private final By drpTicketAmount = By.cssSelector("select[name='TicketAmount']");
    private final By btnBookTicket = By.cssSelector("input[type='submit']");
    private final By lblSuccessMessage = By.cssSelector("h1[align='center']");
    private final By lblFailMessage = By.cssSelector("p[class='message error']");


    //element
    private Select getDrpDepartDate() {
        Select select = new Select(DriverHelper.getDriver().findElement(drpDepartDate));
        return select;
    }

    private Select getDrpDepartFrom() {
        Select select = new Select(DriverHelper.getDriver().findElement(drpDepartFrom));
        return select;
    }

    private Select getDrpArriveAt() {
        Select select = new Select(DriverHelper.getDriver().findElement(drpArriveAt));
        return select;
    }

    private Select getDrpSeatType() {
        Select select = new Select(DriverHelper.getDriver().findElement(drpSeatAt));
        return select;
    }

    private Select getDrpTicketAmount() {
        Select select = new Select(DriverHelper.getDriver().findElement(drpTicketAmount));
        return select;
    }

    private WebElement getBtnBookTicket() {
        return DriverHelper.getDriver().findElement(btnBookTicket);
    }

    private WebElement getSuccessMessage() {
        return DriverHelper.getDriver().findElement(lblSuccessMessage);
    }

    private WebElement getLblFailSuccess() {
        return DriverHelper.getDriver().findElement(lblFailMessage);
    }


    //method
    public void selectDepartDate(String date) {
        getDrpDepartDate().selectByVisibleText(date);
    }

    public void selectDepartFrom(String departFrom) {
        getDrpDepartFrom().selectByVisibleText(departFrom);
    }

    public void selectArriveAt(String arriveAt) {
        getDrpArriveAt().selectByVisibleText(arriveAt);
    }

    public void selectDrpSeatType(String seatType) {
        getDrpSeatType().selectByVisibleText(seatType);
    }

    public void selectDrpTicketAmount(String ticketAmount) {
        getDrpTicketAmount().selectByVisibleText(ticketAmount);
    }

    public String getFailMsg() {
        return getLblFailSuccess().getText();
    }

    public String getSuccessMsg() {
        return getSuccessMessage().getText();
    }

    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatAt, String ticketAmount) {
        ElementHelper.scrollToElement(getBtnBookTicket());
        selectDepartDate(departDate);
        selectDepartFrom(departFrom);
        selectArriveAt(arriveAt);
        selectDrpSeatType(seatAt);
        selectDrpTicketAmount(ticketAmount);
        getBtnBookTicket().click();
    }

    public void bookTicketWithDefaultData() {
        ElementHelper.scrollToElement(getBtnBookTicket());
        getBtnBookTicket().click();
    }
}
