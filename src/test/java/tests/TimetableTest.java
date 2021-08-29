package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.TicketPricePage;
import page_objects.TimetablePage;


public class TimetableTest extends BaseTest {
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();

    @Test(description = "navigate to ticket price when click on check price link")
    public void tc001_NavigateToTicketPricePageWhenClickPriceLink() {
        timetablePage.clickTimetableTab();
        timetablePage.clickCheckPrice("Sài Gòn", "Đà Nẵng");
        String actual = ticketPricePage.getTitleInTicketPrice();

        Assert.assertEquals(actual, String.format("Ticket price from %s to %s", "Sài Gòn", "Đà Nẵng"), "navigate incorrectly");

    }
}
