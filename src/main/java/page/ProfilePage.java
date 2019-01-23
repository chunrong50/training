package page;

import org.openqa.selenium.By;

/**
 * Created by jfpay on 19/1/15.
 */
public class ProfilePage extends BasePage {
    By login = By.id("tv_login");


    public LoginPage gotoLogin() {
        find(login).click();
        return new LoginPage();
    }

}
