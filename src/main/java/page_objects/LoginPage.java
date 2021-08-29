package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static common.Constant.WEBDRIVER;

public class LoginPage extends BasePage {
    //locator
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.cssSelector("input[type='submit']");
    private final By lblWelcomeMessage = By.cssSelector("div#content>h1[align='center']");
    private final By lblErrorMessage = By.cssSelector("div#content>p[class='message error LoginForm']");


    //element
    private WebElement getTxtUsername() {
        return DriverHelper.getDriver().findElement(txtUsername);
    }

    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return DriverHelper.getDriver().findElement(btnLogin);
    }

    private WebElement getLblErrorMsg() {
        return DriverHelper.getDriver().findElement(lblErrorMessage);
    }

    private WebElement getLblWelcome() {
        return DriverHelper.getDriver().findElement(lblWelcomeMessage);
    }

    //methods
    public String getErrorMessage() {
        return this.getLblErrorMsg().getText();
    }

    public String getWelcomeMessage() {
        return this.getLblWelcome().getText();
    }

    public void login(String username, String password) {
        ElementHelper.scrollToElement(getTxtUsername());
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();

    }
}
