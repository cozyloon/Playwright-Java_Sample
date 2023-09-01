package tests;

import com.microsoft.playwright.Page;
import function.Login;
import org.testng.annotations.Test;
import util.TestBase;

import java.nio.file.Paths;

import static util.DriverSetup.page;


public class Example extends TestBase {


    @Test
    public void test() {
        page.navigate(propertyConfig.webUrl());
        Login.userLogin(propertyConfig.username(), propertyConfig.password());
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/example.png")));
    }
}
