package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Created by jfpay on 19/1/15.
 */
public class SelfChoosePage extends BasePage {
    private By search = By.id("action_create_cube");
    private By stock = By.id("portfolio_stockName");


    public SearchPage gotoSearchPage() {
        find(search).click();
        return new SearchPage();
    }


    public StockDetailPage gotoDetailPage(String stockName) {
        find(By.xpath("//*[@text='" + stockName + "' and @id='portfolio_stockName']"));
        return new StockDetailPage();
    }


    /**
     * 通过搜索功能添加自选
     *
     * @param stock
     * @return
     */

    public SelfChoosePage addStock(String stock) {
        SearchPage searchPage = gotoSearchPage().searchKey(stock);
        searchPage.addSelected();
        searchPage.gotoMainPage().gotoSelfChoicePage();
        return this;

    }


    /**
     * 在自选->股票的详情页删除股票
     *
     * @param stock
     * @return
     */
    public SelfChoosePage rmStock(String stock) {
        ArrayList<String> arrayList = getAllStockName();
        for (String text : arrayList)
            if (stock.equals(text)) {
                find(By.xpath("//*[@text," + text + "]")).click();
                break;
            }


        return this;
    }

    /**
     * @return 所有自选股票的名称
     */

    public ArrayList<String> getAllStockName() {
        ArrayList<String> arrayList = new ArrayList<String>();
        wait(6);
        for (WebElement e : finds(stock))
            arrayList.add(e.getText());
        return arrayList;
    }


}
