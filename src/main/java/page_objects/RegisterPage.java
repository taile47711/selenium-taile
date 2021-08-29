package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    //locator
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPID = By.id("pid");
    private final By btnRegister = By.cssSelector("input[type='submit']");
    private final By lblCreateAccount = By.cssSelector("div[id='content']>h1[align='center']");
    private final By lblAccountSuccess = By.cssSelector("div[id='page']>div[id='content']");
    private final By lblErrorMsg = By.cssSelector("p[class='message error']");
    private final By lnkLogin = By.linkText("login");

    //element
    private WebElement getTxtEmail() {
        return DriverHelper.getDriver().findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getTxtPID() {
        return DriverHelper.getDriver().findElement(txtPID);
    }

    private WebElement getBtnRegister() {
        return DriverHelper.getDriver().findElement(btnRegister);
    }

    private WebElement getLblCreateAccount() {
        return DriverHelper.getDriver().findElement(lblCreateAccount);
    }

    private WebElement getlblErrorMessage() {
        return DriverHelper.getDriver().findElement(lblErrorMsg);
    }

    //methods
    public String getErrorMessage() {
        return getlblErrorMessage().getText();
    }

    public void register(String email, String password, String confirm, String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirm);
        getTxtPID().sendKeys(pid);
        getBtnRegister().click();
    }
}
