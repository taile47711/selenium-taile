package tests;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;

public class BookTicketTest extends BaseTest {
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();
    String successMessage = "Ticket Booked Successfully!";

    @Test(description = "click book ticket tab when not loggin yet")
    public void tc001_ClickBookTicketTabWhenNotLogginYet() {
        bookTicketPage.clickBookTicketTab();
        String actual = loginPage.getWelcomeMessage();

        Assert.assertEquals(actual, "Login Page", "Error message is not displayed as expected");
    }

    @Test(description = "click book ticket tab when loggin already")
    public void tc002_ClickBookTicketTabWhenLogginAlready() {
        bookTicketPage.clickBookTicketTab();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        bookTicketPage.bookTicket("9/7/2021", "Phan Thiết", "Nha Trang", "Hard bed", "2");
        String actual = bookTicketPage.getSuccessMsg();

        Assert.assertEquals(actual, successMessage, "Error message is not displayed as expected");
    }

    @Test(description = "book ticket with valid data")
    public void tc003_BookTicketWithValidData() {
        bookTicketPage.clickBookTicketTab();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        bookTicketPage.bookTicket("9/9/2021", "Sài Gòn", "Phan Thiết", "Hard bed", "1");
        String actual = bookTicketPage.getSuccessMsg();
        Assert.assertEquals(actual, successMessage, "Error message is not displayed as expected");
    }

    @Test(description = "book ticket with default data")
    public void tc003_BookTicketWithDefaultData() {
        bookTicketPage.clickBookTicketTab();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        bookTicketPage.bookTicketWithDefaultData();
        String actual = bookTicketPage.getSuccessMsg();
        Assert.assertEquals(actual, successMessage, "Error message is not displayed as expected");
    }

}
