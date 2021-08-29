package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage {

    //locator
    //them thuoc tinh
    private String dynamicCheckPrice = "//table[@class='MyTable WideTable']/tbody/tr/td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/a[text()='check price']";
    private String dynamicBookTicket = "//table[@class='MyTable WideTable']/tbody/tr/td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/a[text()='book ticket']";

    //element
    private WebElement getCheckPrice(String departStation, String arriveStation) {
        By dynamicTrain = By.xpath(String.format(dynamicCheckPrice, departStation, arriveStation));
        return DriverHelper.getDriver().findElement(dynamicTrain);
    }

    private WebElement getBookTicket(String departStation, String arriveStation) {
        By dynamicTrain = By.xpath(String.format(dynamicBookTicket, departStation, arriveStation));
        return DriverHelper.getDriver().findElement(dynamicTrain);
    }

    //method
    public void clickCheckPrice(String departStation, String arriveStation) {
        getCheckPrice(departStation, arriveStation).click();
    }

    public void clickBookTicket(String departStation, String arriveStation) {
        getBookTicket(departStation, arriveStation).click();
    }
}
