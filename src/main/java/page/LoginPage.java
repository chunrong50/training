package page;

import org.openqa.selenium.By;

/**
 * Created by jfpay on 19/1/15.
 */
public class LoginPage extends BasePage {
    private By other = By.id("tv_login_by_phone_or_others");
    private By accountLogin = By.id("tv_login_with_account");
    private By username = By.xpath("//*[@text='请输入手机号或邮箱']");
    private By password = By.id("login_password");
    private By loginButton = By.id("button_next");
    private By loginTip = By.xpath("//*[@resource-id='com.xueqiu.android:id/md_content']");
    private By defalutSure = By.xpath("//*[@resource-id='com.xueqiu.android:id/md_buttonDefaultPositive']");


    private By cancle = By.xpath("//*[@resource-id='com.xueqiu.android:id/iv_action_back']");


    public LoginPage loginFail(String username, String password) {

        find(other).click();
        find(accountLogin).click();
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(this.loginButton).click();
        wait(2);
        return new LoginPage();
    }

    public MainPage loginSuccess(String username, String password) {
        find(other).click();
        find(accountLogin).click();
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(this.loginButton).click();
        return new MainPage();
    }

    public ProfilePage gotoProfilePage() {
        find(cancle).click();
        return new ProfilePage();
    }


    /**
     * 获取登录提示信息
     *
     * @return
     */
    public String getLoginResult() {
        String result = BasePage.find(loginTip).getText();
        BasePage.find(this.defalutSure).click();
        return result;
    }

}
