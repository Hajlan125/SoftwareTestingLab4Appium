package PageObjects;

import io.appium.java_client.android.AndroidDriver;

public class SettingsPage {
    AndroidDriver driver;
    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
    }
    public void darkThemeOnOff() {
        driver.tap(1,960, 790,300);
    }
    public void mailPageReturning() {
        driver.findElementByAccessibilityId("Navigate up").click();
    }

}
