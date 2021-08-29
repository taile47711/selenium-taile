package tests;

import common.Constant;
import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {


    @BeforeMethod
    public void setup() {
        DriverHelper.initDriver();
        DriverHelper.navigate(Constant.URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverHelper.quit();
    }
}
