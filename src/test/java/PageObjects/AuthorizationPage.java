package PageObjects;

import io.appium.java_client.android.AndroidDriver;

public class AuthorizationPage {
    AndroidDriver driver;
    public AuthorizationPage(AndroidDriver driver){
        this.driver = driver;
    }
    public void waiting(int delay) throws InterruptedException {
        synchronized (driver){
            driver.wait(delay);
        }
    }
    public void authorizationByYandex() throws InterruptedException {
        driver.findElementById("ru.yandex.mail:id/list_yandex").click();
        waiting(5000);

        driver.findElementById("ru.yandex.mail:id/edit_login").sendKeys("AdRGaraev");
        driver.findElementById("ru.yandex.mail:id/button_next").click();
        waiting(5000);

        driver.findElementById("ru.yandex.mail:id/edit_password").sendKeys("zut47wt8");
        driver.findElementById("ru.yandex.mail:id/button_next").click();
        waiting(15000);
        driver.findElementById("ru.yandex.mail:id/go_to_mail_button").click();

    }
}
