import driver.Driver;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.SearchPage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jfpay on 19/1/14.
 */
public class SearchTest {
    static MainPage mainPage;
    static SearchPage searchPage;


    @BeforeAll
    static void beforeAll() {
        Driver.start();
        mainPage = new MainPage();
        searchPage = mainPage.gotoSearchPage();
    }

    @ParameterizedTest
    @CsvSource({
            "pdd,拼多多",
            "alibaba,阿里巴巴",
            "sougou,搜狗"


    })
    public void searchContent(String keyWord, String expection) {

        String name = searchPage.searchKey(keyWord).getAll().get(0);
        assertThat(name, equalTo(expection));

    }

    @Test
    public void 判断自选属性() {
        String content = searchPage.searchKey("pdd").addSelected();
        assertThat(content, equalTo("com.xueqiu.android:id/followed_btn"));
        searchPage.searchKey("pdd").addSelected();  //数据恢复,为下次用例执行成功
    }


}
