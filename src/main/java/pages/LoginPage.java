package pages;


import static util.DriverSetup.page;

public class LoginPage {
    private String txtUsername = "id=user-name";
    private String txtPassword = "Password";
    private String btnLogin = "id=login-button";

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
