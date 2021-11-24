package PageObjects;

import io.appium.java_client.android.AndroidDriver;

public class MailPage {
    AndroidDriver driver;
    public MailPage(AndroidDriver driver) {
        this.driver = driver;
    }
    public void sendedMailsCheck() {
        driver.findElementByAccessibilityId("Open menu").click();
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[7]").click();
    }
    public void settingsPageOpening() throws InterruptedException {
        driver.findElementByAccessibilityId("Open menu").click();
        waiting(1000);

        driver.swipe(300,1700,300,100,500);
        waiting(1000);

        driver.tap(1,200,1430, 300);
    }
    public void logout() {
        driver.tap(1,200,1680,300);
    }
    public void waiting(int delay) throws InterruptedException {
        synchronized (driver){
            driver.wait(delay);
        }
    }
}
