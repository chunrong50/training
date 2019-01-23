import driver.Driver;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jfpay on 19/1/14.
 */
public class LoginTest {

    static MainPage mainPage;
    static ProfilePage profilePage;


    @BeforeAll
    static void beforeAll() {
        Driver.start();
        mainPage = new MainPage();
        profilePage = mainPage.gotoProfilePage();

    }

    @ParameterizedTest
    @CsvSource({"1561800000,888888,手机号码填写错误",
            "15619009111,777777,用户名或密码错误"})
    public void LoginNumErro(String username, String password, String expection) {

        LoginPage loginPage = profilePage.gotoLogin();
        loginPage.loginFail(username, password);
        assertThat(loginPage.getLoginResult(), equalTo(expection));
        loginPage.gotoProfilePage();
    }


}

