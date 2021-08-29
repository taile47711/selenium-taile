package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.TicketPricePage;

public class TicketPriceTest extends BaseTest {
    TicketPricePage ticketPricePage = new TicketPricePage();

    @Test(description = "navigate to ticket price page when click check price button")
    public void tc001_NavigateToTicketPricePageWhenClickPriceButton() {
        ticketPricePage.clickTicketPriceTab();
        ticketPricePage.clickCheckPrice("Sài Gòn", "Phan Thiết");
        String actual = ticketPricePage.getTitleInTicketPrice();
        Assert.assertEquals(actual, String.format("Ticket price from %s to %s", "Sài Gòn", "Phan Thiết"), "navigate incorrectly");
    }
}
