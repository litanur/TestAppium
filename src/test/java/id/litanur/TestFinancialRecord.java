package id.litanur;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestFinancialRecord {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "sdk_gphone_x86");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, dc);
    }
    @Test
    public void testAddIncome() {
        MobileElement logo = driver.findElementByClassName("android.widget.ImageView");
        logo.click();
        delay(5);
        MobileElement addData = driver.findElementById("com.chad.financialrecord:id/fabMenu");
        addData.click();
        delay(5);
        MobileElement chooseIncome = driver.findElementById("com.chad.financialrecord:id/btnIncome");
        chooseIncome.click();
        delay(5);
        MobileElement calendar = driver.findElementById("com.chad.financialrecord:id/tvDate");
        calendar.click();
        delay(5);
        MobileElement setDate = driver.findElementByAccessibilityId("05 Juni 2023");
        setDate.click();
        delay(5);
        MobileElement okDate = driver.findElementById("android:id/button1");
        okDate.click();
        delay(5);
        MobileElement setAmount = driver.findElementById("com.chad.financialrecord:id/etAmount");
        setAmount.click();
        setAmount.sendKeys("120000");
        delay(5);
        MobileElement note = driver.findElementById("com.chad.financialrecord:id/etNote");
        note.click();
        note.sendKeys("uang jajan piceh");
        driver.hideKeyboard();
        delay(5);
        MobileElement save = driver.findElementById("com.chad.financialrecord:id/btSave");
        save.click();
        delay(5);
        MobileElement title = driver.findElementById("com.chad.financialrecord:id/btDate");
        String actualResult = title.getText();
        String expectedResult = "Jun 2023";
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println("Tambah data pemasukan berhasil");
    }

    public void delay(int second) {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
