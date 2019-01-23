package page;

import org.openqa.selenium.By;

/**
 * Created by jfpay on 19/1/15.
 */
public class MainPage extends BasePage {
    private By profile = By.id("user_profile_icon");
    private By searchEdit = By.id("home_search");
    private By selfAdd = By.xpath("//*[@resource-id='android:id/tabs']/android.widget.RelativeLayout[2]");


    public ProfilePage gotoProfilePage() {

        find(profile).click();
        return new ProfilePage();

    }

    public SearchPage gotoSearchPage() {
        find(searchEdit).click();
        return new SearchPage();

    }

    public SelfChoosePage gotoSelfChoicePage() {


        find(selfAdd).click();
        return new SelfChoosePage();
    }
}
