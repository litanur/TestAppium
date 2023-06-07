package id.litanur;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCalculator {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "sdk_gphone_x86");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.google.android.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, dc);
    }
    @Test
    public void testAdd() {
        MobileElement tombolSatu = driver.findElementByAccessibilityId("1");
        MobileElement tombolDua = driver.findElementByAccessibilityId("2");
        MobileElement tombolPlus = driver.findElementByAccessibilityId("plus");
        MobileElement tombolSamaDengan = driver.findElementByAccessibilityId("equals");
        tombolSatu.click();
        tombolPlus.click();
        tombolDua.click();
        tombolSamaDengan.click();
        MobileElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        String actualResult = result.getText();
        String expectedResult = "3";
        Assert.assertEquals(actualResult, expectedResult);

    }
}
