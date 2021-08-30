package tests;

import common.Constant;
import helpers.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setup() {
        DriverHelper.initDriver();
        DriverHelper.navigate(Constant.URL);
    }

    @AfterMethod
    public void tearDown() {
//        DriverHelper.quit();
    }
}