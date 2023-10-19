package pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    private String lblLogo = ".app_logo";


    public String getDisplayedLogoText() {
        return page.locator(lblLogo).textContent();
    }
}
