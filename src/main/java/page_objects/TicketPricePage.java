package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends BasePage {

    //locator
    //them thuoc tinh
    private String dynamicTicketPrice = "//table[@class='NoBorder']/tbody/tr/td/descendant::li[text()='%s to %s']/following::a[text()='Check Price']";
    private final By lblText = By.xpath("//th[contains(text(),'Ticket price from')]");

    //element
    private WebElement getTicketPrice(String departStation, String arriveStation) {
        By dynamicTicket = By.xpath(String.format(dynamicTicketPrice, departStation, arriveStation));
        return DriverHelper.getDriver().findElement(dynamicTicket);
    }

    private WebElement getLblText() {
        return DriverHelper.getDriver().findElement(lblText);
    }

    //method
    public String getTitleInTicketPrice() {//sua lai ten
        return getLblText().getText();
    }

    public void clickCheckPrice(String departStation, String arriveAt) {
        getTicketPrice(departStation, arriveAt).click();
    }
}
