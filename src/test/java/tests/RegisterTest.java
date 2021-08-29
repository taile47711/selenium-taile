package tests;

import com.github.javafaker.Faker;
import helpers.DataHelper;
import helpers.DateHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.RegisterPage;

public class RegisterTest extends BaseTest {
    Faker faker = new Faker();
    RegisterPage registerPage = new RegisterPage();
    String errorMessage = "There're errors in the form. Please correct the errors and try again.";
    String email = "";
    String password = "";
    String pid = "";

    @Test(description = "register with blank all fields")
    public void tc001_RegisterWithBlankAllFields() {
        registerPage.clickRegisterTab();
        registerPage.register("", "", "", "");
        String actual = registerPage.getErrorMessage();

        Assert.assertEquals(actual, errorMessage, "Error message is not displayed as expected");
    }

    @Test(description = "register with blank email field")
    public void tc002_RegisterWithBlankEmailField() {
        registerPage.clickRegisterTab();
        pid = faker.numerify("########");
        password = faker.letterify("????????");
        registerPage.register(email, password, password, pid);
        String actual = registerPage.getErrorMessage();

        Assert.assertEquals(actual, errorMessage, "Error message is not displayed as expected");
    }

    @Test(description = "register with blank password field")
    public void tc003_RegisterWithBlankPasswordField() {
        registerPage.clickRegisterTab();
        pid = DataHelper.getValidPID(8);
        email = DataHelper.getRandomEmail();
        registerPage.register(email, password, password, pid);
        String actual = registerPage.getErrorMessage();

        Assert.assertEquals(actual, errorMessage, "Error message is not displayed as expected");
    }

    @Test(description = "register with blank PID field")
    public void tc004_RegisterWithBlankPIDField() {
        registerPage.clickRegisterTab();
        email = DataHelper.getRandomEmail();
        password = DataHelper.getRandomPassword(10);
        registerPage.register(email, password, password, pid);
        String actual = registerPage.getErrorMessage();

        Assert.assertEquals(actual, errorMessage, "Error message is not displayed as expected");
    }

    @Test(description = "register with password has 7 characters")
    public void tc005_RegisterWithPasswordHas7Characters() {
        registerPage.clickRegisterTab();
        pid = DataHelper.getRandomPID(8);
        password = DataHelper.getRandomPassword(7);
        email = DataHelper.getRandomEmail();
        registerPage.register(email, password, password, pid);
        String actual = registerPage.getErrorMessage();

        Assert.assertEquals(actual, errorMessage, "Error message is not displayed as expected");
    }

    @Test(description = "register with confirm password unmatch with password")
    public void tc006_RegisterWithConfirmPasswordUnmatchWithPassowrd() {
        registerPage.clickRegisterTab();
        pid = DataHelper.getRandomPID(8);
        password = DataHelper.getRandomPassword(12);
        email = DataHelper.getRandomEmail();
        registerPage.register(email, password, "123454", pid);
        String actual = registerPage.getErrorMessage();

        Assert.assertEquals(actual, errorMessage, "Error message is not displayed as expected");
    }

    @Test(description = "register with PID has 7 characters")
    public void tc007_RegisterWithPIDdHas7Characters() {
        registerPage.clickRegisterTab();
        pid = DataHelper.getRandomPID(7);
        password = DataHelper.getRandomPassword(12);
        email = DataHelper.getRandomEmail();
        registerPage.register(email, password, password, pid);
        String actual = registerPage.getErrorMessage();

        Assert.assertEquals(actual, errorMessage, "Error message is not displayed as expected");

    }

}
