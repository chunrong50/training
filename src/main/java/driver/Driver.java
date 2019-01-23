package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by jfpay on 19/1/14.
 */
public class Driver {
    private static AppiumDriver<AndroidElement> driver;

    static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    public static void start() {
        desiredCapabilities.setCapability("platformVersion", "6.0");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "Galaxy Nexus API 26");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("app", "/Users/jfpay/Desktop/apk/com.xueqiu.android.apk");
        desiredCapabilities.setCapability("autoGrantPermissions", true);

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }

    public static AppiumDriver<AndroidElement> getCurrentDriver() {
        return driver;
    }


}
