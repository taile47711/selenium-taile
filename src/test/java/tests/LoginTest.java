package tests;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    String errorMessage = "There was a problem with your login and/or errors exist in your form.";

    @Test(description = "login with valid account")
    public void tc001_LoginWithValidAccount() {
        loginPage.clickLoginTab();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actual = loginPage.getWelcomeMessage();

        Assert.assertEquals(actual, "Welcome to Safe Railway", "Error message is not displayed as expected");
    }

    @Test(description = "login with blank email field")
    public void tc002_LoginWithBlankEmailField() {
        loginPage.clickLoginTab();
        loginPage.login("", Constant.PASSWORD);
        String actual = loginPage.getErrorMessage();

        Assert.assertEquals(actual, errorMessage, "Error message is not displayed as expected");
    }

    @Test(description = "login with blank password field")
    public void tc003_LoginWithBlankPasswordField() {
        loginPage.clickLoginTab();
        loginPage.login(Constant.USERNAME, "");
        String actual = loginPage.getErrorMessage();

        Assert.assertEquals(actual, errorMessage, "Error message is not displayed as expected");
    }

    @Test(description = "login with blank fields")
    public void tc004_LoginWithBlankFields() {
        loginPage.clickLoginTab();
        loginPage.login("", "");
        String actual = loginPage.getErrorMessage();

        Assert.assertEquals(actual, errorMessage, "Error message is not displayed as expected");
    }

    @Test(description = "login with unformat email")
    public void tc005_LoginWithUnformatEmail() {
        loginPage.clickLoginTab();
        loginPage.login("logigeargmail.com", Constant.PASSWORD);
        String actual = loginPage.getErrorMessage();
        String expected = "Invalid username or password. Please try again.";

        Assert.assertEquals(actual, expected, "Error message is not displayed as expected");
    }

    @Test(description = "login with email doesn't exist")
    public void tc006_LoginWithEmailDoesntExist() {
        loginPage.clickLoginTab();
        loginPage.login("logigear1254@gmail.com", Constant.PASSWORD);
        String actual = loginPage.getErrorMessage();
        String expected = "Invalid username or password. Please try again.";

        Assert.assertEquals(actual, expected, "Error message is not displayed as expected");
    }
}
