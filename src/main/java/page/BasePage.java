package page;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    By next = By.id("md_buttonDefaultNegative");
    By comment = By.id("md_buttonDefaultPositive");

    /**
     * 元素定位方法
     *
     * @param locator
     * @return
     */
    public static WebElement find(By locator) {
        ArrayList<String> other = new ArrayList<String>();
        other.add("md_buttonDefaultNegative"); //弹框--下次再说的id
        WebElement element;

        try {

            element = Driver.getCurrentDriver().findElement(locator);
        } catch (Exception e) {
            System.out.println("not found,entry catch");
            //  e.printStackTrace();
            //更好的根据弹框列表进行批量检索
            for (String s : other) {
                if (Driver.getCurrentDriver().getPageSource().contains(s))
                    Driver.getCurrentDriver().findElement(By.id(s)).click();
            }
            element = Driver.getCurrentDriver().findElement(locator);
        }
        return element;
    }


    public static List<AndroidElement> finds(By locator) {
        ArrayList<String> other = new ArrayList<String>();
        other.add("md_buttonDefaultNegative"); //弹框--下次再说的id
        List<AndroidElement> elements = new ArrayList<AndroidElement>();

        try {
            elements = Driver.getCurrentDriver().findElements(locator);
        } catch (Exception e) {
            System.out.println("not found");
            e.printStackTrace();
            //更好的根据弹框列表进行批量检索
            for (String s : other) {
                if (Driver.getCurrentDriver().getPageSource().contains(s))
                    Driver.getCurrentDriver().findElement(By.id(s)).click();
            }
            elements = Driver.getCurrentDriver().findElements(locator);
        }
        return elements;
    }


    /**
     * 隐试等待,单位秒
     *
     * @param i
     */
    public static void wait(int i) {
        Driver.getCurrentDriver().manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

    }
}
