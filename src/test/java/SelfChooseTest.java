import driver.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.SelfChoosePage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SelfChooseTest {
    static MainPage mainPage;
    static SelfChoosePage selfChoosePage;


    @BeforeAll
    static void before() {
        Driver.start();
        mainPage = new MainPage();
    }

    /**
     * 自选主页中搜索股票,然后加自选,判断自选是否成功
     *
     * @param stock
     * @param expection
     */

    @ParameterizedTest
    @CsvSource({"alibaba,阿里巴巴"
    })
    public void addChoiceTest(String stock, String expection) {
        selfChoosePage = mainPage.gotoSelfChoicePage();
        selfChoosePage.addStock(stock);
        ArrayList<String> arrayList = selfChoosePage.getAllStockName();
        assertThat(arrayList.get(0), equalTo(expection));
    }


    @AfterAll
    static void after() {
        selfChoosePage.gotoSearchPage().searchKey("alibaba").rmSelected();
    }
}
