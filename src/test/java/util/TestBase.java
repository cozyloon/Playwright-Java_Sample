package util;


import config.PropertyConfig;
import org.aeonbits.owner.ConfigCache;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class TestBase {
    public SoftAssert softAssert;


    public static PropertyConfig propertyConfig = ConfigCache.getOrCreate(PropertyConfig.class);

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser) {
        DriverSetup.launchPlaywright(browser);
    }

    @AfterClass
    public void afterClass() {
        DriverSetup.closePlaywright();
    }

    @BeforeMethod
    public void beforeMethod() {
        DriverSetup.createContextAndPage();
    }

    @AfterMethod
    public void afterMethod() {
        DriverSetup.closeContext();
    }

    @BeforeTest
    public void beforeTest() {
        this.softAssert = new SoftAssert();
    }
}
