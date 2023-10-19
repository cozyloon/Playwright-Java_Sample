package pages;


import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private String txtUsername = "#user-name";
    private String txtPassword = "Password";
    private String btnLogin = "#login-button";

    public LoginPage(Page page) {
        this.page = page;
    }

    public HomePage userLogin(String username, String password) {
        page.locator(txtUsername).type(username);
        page.getByPlaceholder(txtPassword).type(password);
        page.locator(btnLogin).press("Enter");
        return new HomePage(page);
    }

    public void setUsername(String username) {
        page.locator(txtUsername).type(username);
    }

    public void setPassword(String password) {
        page.getByPlaceholder(txtPassword).type(password);
    }

    public void clickLoginBtn() {
        page.locator(btnLogin).press("Enter");
    }
}
