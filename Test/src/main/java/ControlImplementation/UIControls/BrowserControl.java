package ControlImplementation.UIControls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BrowserControl {

    private static WebDriver driver;

    public void start (String webBrowser, String... mobilePhone){
        try {
            switch (webBrowser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
                    if(mobilePhone.length>0){
                        Map<String, String> mobileEmulation = new HashMap<>();
                        mobileEmulation.put("deviceName", mobilePhone[0]);
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                        driver = new ChromeDriver(chromeOptions);
                    } else {
                        driver = new ChromeDriver();
                    }
                    break;
                case "mozilla":
                    break;
                case "safari":
                    break;
                    default:
                        System.out.println("NO");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        BrowserControl.driver = driver;
    }
}
