package page;

import org.openqa.selenium.By;

public class StockDetailPage extends BasePage {
    private By setChoose = By.xpath("//*[@text='设自选']");
    private By delete = By.xpath("//*[@text='删除自选']");
    private By back = By.id("action_back");


    public StockDetailPage rmSelfChooseStock() {

        find(setChoose).click();
        find(delete).click();
        return this;
    }


    public SeletedPage gotoSelfChoosePage() {
        find(back).click();
        return new SeletedPage();
    }

}
