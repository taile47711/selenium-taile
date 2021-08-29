package helpers;

import common.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ElementHelper extends Constant {
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverHelper.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
