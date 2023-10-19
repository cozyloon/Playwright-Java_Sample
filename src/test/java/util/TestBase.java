package util;


import config.PropertyConfig;
import org.aeonbits.owner.ConfigCache;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class TestBase {
    public SoftAssert softAssert;


    public static PropertyConfig propertyConfig = ConfigCache.getOrCreate(PropertyConfig.class);

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser) {
        DriverSetup.launchPlaywright(browser);
        DriverSetup.createContextAndPage();
    }

    @AfterMethod
    public void afterMethod() {
        DriverSetup.closeContext();
        DriverSetup.closePlaywright();
    }

    @BeforeTest
    public void beforeTest() {
        this.softAssert = new SoftAssert();
    }
}
