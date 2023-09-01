package function;

import pages.LoginPage;

public class Login {
     static LoginPage loginPage = new LoginPage();

    public static void userLogin(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
    }
}
