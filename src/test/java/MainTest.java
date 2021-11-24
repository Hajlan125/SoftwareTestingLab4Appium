import PageObjects.AuthorizationPage;
import PageObjects.MailPage;
import PageObjects.SettingsPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MainTest {
    private AndroidDriver driver;
    private AuthorizationPage autorizationPage;
    private MailPage mailPage;
    private SettingsPage settingsPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // iPhone Simulator, iPad Simulator, iPhone Retina 4-inch, Android Emulator, Galaxy S4 и т.д.
        // На iOS, это должно быть одно  из допустимых устройств. На Android эта возможность в настоящее время игнорируется,
        // но параметр является обязательным
        capabilities.setCapability("deviceName", "pixel");
        // Имя ОС на мобильном устройстве
        capabilities.setCapability("platformName", "Android");
        // Версия ОС
        capabilities.setCapability("platformVersion", "9.0");
        // Уникальный индефикатор подключенного устройства
        capabilities.setCapability("udid", "emulator-5554");
        // Java-пакет Android приложения, которое мы хотим запустить. (APK info)
        capabilities.setCapability("app", "/Users/adelgaraev/Downloads/ru.yandex.mail_8.2.1_92370.apk");
        capabilities.setCapability("appPackage", "ru.yandex.mail");
        // Имя activity которые мы хотим запустить из пакета, указанного выше. (APK info)
        capabilities.setCapability("appActivity", "ru.yandex.mail.ui.LoginActivity");
        //export PATH="$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools:$PATH"

        //capabilities.setCapability("app", "ru.yandex.mail_8.2.1_92370.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        autorizationPage = new AuthorizationPage(driver);
        mailPage = new MailPage(driver);
        settingsPage = new SettingsPage(driver);
    }

    @Test
    public void testAddition() throws InterruptedException {
        waiting(3000);

        autorizationPage.authorizationByYandex();
        waiting(5000);

        mailPage.sendedMailsCheck();
        waiting(3000);

        mailPage.settingsPageOpening();
        waiting(1000);


        settingsPage.darkThemeOnOff();
        waiting(3000);

        settingsPage.mailPageReturning();
        waiting(3000);

        mailPage.logout();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    public void waiting(int delay) throws InterruptedException {
        synchronized (driver){
            driver.wait(delay);
        }
    }


}