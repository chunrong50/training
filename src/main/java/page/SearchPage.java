package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

/**
 * Created by jfpay on 19/1/15.
 * 搜索页面
 */
public class SearchPage extends BasePage {
    private By searchInput = By.id("search_input_text");
    private By allstockName = By.id("stockName");
    private By select = By.xpath("//*[contains(@resource-id,'follow') and contains(@resource-id,'_btn')]");
    private By cancle = By.xpath("//*[contains(@resource-id,'action_close') and contains(@text,'取消')]");

    public SearchPage searchKey(String keyWord) {
        find(searchInput).sendKeys(keyWord);

        return this;

    }

    /**
     * 获取搜索列表的文本内容
     *
     * @return
     */


    public ArrayList<String> getAll() {
        ArrayList<String> listName = new ArrayList<String>();

        for (WebElement e : finds(allstockName)) {
            listName.add(e.getText());
        }
        return listName;
    }

    public SearchPage getBystock() {
        return this;
    }

    /**
     * 获取搜索结果加自选/删自选
     *
     * @return 自选处的resource-id的属性值
     */
    public String addSelected() {

        WebElement e = null;
        e = finds(select).get(0);

        e.click();
        if (!e.isDisplayed()) {
            find(select);
        }
        return e.getAttribute("resourceId");

    }

    public String rmSelected() {
        WebElement e = null;
        String attribute = null;
        e = finds(select).get(0);
        attribute = e.getAttribute("resourceId");
        if (attribute.contains("followed_btn")) {
            e.click();
        }
        return attribute;
    }


    public MainPage gotoMainPage() {
        find(cancle).click();
        return new MainPage();
    }


}
