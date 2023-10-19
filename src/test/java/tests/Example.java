package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import util.TestBase;


import static util.DriverSetup.page;


public class Example extends TestBase {


    @Test(priority = 1)
    public void testSlider() {
        page.navigate(propertyConfig.webUrl());
        LoginPage login = new LoginPage(page);
        login.setUsername(propertyConfig.username());
        login.setPassword(propertyConfig.password());
        login.clickLoginBtn();
    }

    @Test(priority = 2)
    public void testChaining() {
        page.navigate(propertyConfig.webUrl());
        LoginPage login = new LoginPage(page);
        String displayedLogoText = login.userLogin(propertyConfig.username(), propertyConfig.password())
                .getDisplayedLogoText();
        Assert.assertEquals(displayedLogoText, "Swag Labs");
    }
}
