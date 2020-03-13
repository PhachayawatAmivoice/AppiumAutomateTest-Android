import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

public class AndroidAppium {

    /*
    Appium Tutorial (2019 Update) Step by Step Appium Automation
    https://www.swtestacademy.com/appium-tutorial/


     */

    WebDriver driver;
    WebDriverWait wait;

    String packageID = "com.amivoicethai.amivoicerecorder:id/";

    @Before
    public void setUp() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities cap = new DesiredCapabilities();

        //change device
        cap.setCapability("deviceName", "SM-T365-v5.1.1");
        cap.setCapability("platformVersion", "9");
        cap.setCapability("udid","d48a905b"); ///get UUID from cmd adb devices

        cap.setCapability("platformName", "Android");
        cap.setCapability("appPackage", "com.amivoicethai.amivoicerecorder");
        cap.setCapability("appActivity", "com.amivoicethai.amivoicerecorder.ViewSplashActivity");
        cap.setCapability( "allowTestPackages",true);
        cap.setCapability("noReset", true);

        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }


    @Test
    public void firstTest() {
        //audioRecordTest();
        sendLogTest();
       // setTimeUploadAudioTest();
        //resetBluetoothMic();
       // connectBluetooth();
    }

    public void clickTest(){
        WebElement element =  driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.amivoicethai.amivoicerecorder:id/button_send_log_file']"));
        element.click();
    }


    public void audioRecordTest(){
        //start rec
        //wait 5 mn.
        //stop rec

        //click start
        String button_start_rec_ID = packageID + "button_start_record_";
        WebElement elementStart =  driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + button_start_rec_ID + "']"));
        elementStart.click();

        //wait 20 sec.
        try {
            Thread.sleep(30 * 1000);
            //click stop
            String button_stop_rec_ID = packageID + "button_stop_record_";
            WebElement elementStop =  driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + button_stop_rec_ID + "']"));
            elementStop.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendLogTest(){
        //click send Log
        //click YES (popup dialog)
        //or
        //Cancel

        String resourceID = packageID + "button_send_log_file" ;
        WebElement element =  driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + resourceID + "']"));
        element.click();

        // wait = new WebDriverWait(driver, 10);
        // String popupYesID = "android:id/button1";

        try {
            Thread.sleep(3000);
            //text='ยืนยัน'
            //text='ยกเลิก'
            WebElement elementYes = driver.findElement(By.xpath("//android.widget.Button[@text='ยืนยัน']"));
            elementYes.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void setTimeUploadAudioTest(){

        //click set time
        //key passlock
        String resourceID = packageID + "textView_set_timer";
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='" + resourceID + "']"));
        element.click();

        try {
            Thread.sleep(2 * 1000);
            //key password
            String editTextID = packageID + "editText_enter_password";
            WebElement elementEdt = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='" + editTextID + "']"));
           elementEdt.sendKeys("1234");



            //Creating object of Actions class
            Actions builder = new Actions(driver);
            builder.click(elementEdt).sendKeys("LOL").perform();

            //Method2:Comment Method1
            //Action enterDataOnTextCanvas2= builder.keyDown(Keys.SHIFT).sendKeys("Tanawat").keyUp(Keys.SHIFT).build();
            //enterDataOnTextCanvas2.perform();

            //Generating an action to type a text in CAPS
//            Action typeInCAPS = builder.sendKeys(Keys.ENTER)
//                    .click()
//                    .build();
//            //Performing the typeInCAPS action
//            typeInCAPS.perform();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void resetBluetoothMic(){
        String resourceID = packageID + "button_connect_bluetooth_mic" ;
        WebElement element =  driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + resourceID + "']"));
        //element.click();

        //Creating object of Actions class
        Actions builder = new Actions(driver);
        builder.clickAndHold(element).perform();

        try {
            Thread.sleep(2000);
            //text='ยืนยัน'
            //text='ยกเลิก'
            WebElement elementYes = driver.findElement(By.xpath("//android.widget.Button[@text='ยืนยัน']"));
            elementYes.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateBluetoothMicVolume(){
        //imageView_audio_source
        String resourceID = packageID + "imageView_audio_source" ;
        WebElement element =  driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='" + resourceID + "']"));
        element.click();
    }

    public void connectBluetooth(){
        String resourceID = packageID + "button_connect_bluetooth_mic" ;
        WebElement element =  driver.findElement(By.xpath("//android.widget.Button[@resource-id='" + resourceID + "']"));
        element.click();
    }

//    public void setAttributeValue(WebElement elem, String value){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
//        js.executeScript(scriptSetAttrValue, elem, "value", value);
//    }


}
