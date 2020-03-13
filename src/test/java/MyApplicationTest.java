import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;
import java.net.URL;

public class MyApplicationTest {


    WebDriver driver;
    WebDriverWait wait;

    String packageID = "pch.amivoicethai.myapplicationtest:id/";

    @Before
    public void setUp() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities cap = new DesiredCapabilities();


        //change device
        cap.setCapability("deviceName", "SM-T365-v5.1.1");
        cap.setCapability("platformVersion", "5.1.1");
        cap.setCapability("udid", "emulator-5554");

        cap.setCapability("platformName", "Android");
        cap.setCapability("appPackage", "pch.amivoicethai.myapplicationtest");
        cap.setCapability("appActivity", ".MainActivity");
        cap.setCapability("allowTestPackages", true);
        cap.setCapability("noReset", true);

        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }

    @Test
    public void firstTest() {
        //clickPopupTest();
        clickRecordTest();
        //clickKeyPassword();
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }


    public void clickPopupTest() {
        String resourceID = "pch.amivoicethai.myapplicationtest:id/button_show_popup";
        WebElement element = driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + resourceID + "']"));
        element.click();

        // wait = new WebDriverWait(driver, 10);
        // String popupYesID = "android:id/button1";

        try {
            Thread.sleep(3000);
            //text='Cancel'
            //text='OK'
            WebElement elementYes = driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']"));
            elementYes.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void clickRecordTest() {
        String button_start_rec_ID = "pch.amivoicethai.myapplicationtest:id/button_start_rec";
        WebElement elementStart = driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + button_start_rec_ID + "']"));
        elementStart.click();

        try {
            Thread.sleep(10 * 1000);
            String button_stop_rec_ID = "pch.amivoicethai.myapplicationtest:id/button_stop_rec";
            WebElement elementStop = driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + button_stop_rec_ID + "']"));
            elementStop.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void clickKeyPassword() {
        //click set time
        //key passlock
        String resourceID = "pch.amivoicethai.myapplicationtest:id/button_key_password";
        WebElement element = driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + resourceID + "']"));
        element.click();

        try {
            Thread.sleep(2 * 1000);
            //key password
            String editTextID = "pch.amivoicethai.myapplicationtest:id/editText_enter_password";
            WebElement elementEdt = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='" + editTextID + "']"));
            elementEdt.sendKeys("1234");

            //Creating object of Actions class
            Actions builder = new Actions(driver);
            //Generating an action to type a text in CAPS
            Action typeInCAPS = builder.sendKeys(Keys.ENTER)
                    .build();
            //Performing the typeInCAPS action
            typeInCAPS.perform();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
