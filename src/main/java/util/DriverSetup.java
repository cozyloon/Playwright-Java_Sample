package util;

import com.microsoft.playwright.*;

import java.awt.*;


public class DriverSetup {
    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    public static Page page;

    public static void launchPlaywright(String browserName) {

        playwright = Playwright.create();
        browser = null;

        if ("chromium".equalsIgnoreCase(browserName)) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(50));
        } else if ("firefox".equalsIgnoreCase(browserName)) {
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(50));
        } else if ("webkit".equalsIgnoreCase(browserName)) {
            browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(50));
        } else if ("edge".equalsIgnoreCase(browserName)) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(50)
                    .setChannel("msedge"));
        } else if ("chrome".equalsIgnoreCase(browserName)) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setSlowMo(50)
                    .setChannel("chrome"));
        }
        assert browser != null;
    }

    public static void createContextAndPage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(width, height));
        page = context.newPage();
    }

    public static void closeContext() {
        context.close();
    }

    public static void closePlaywright() {
        playwright.close();
    }


}
