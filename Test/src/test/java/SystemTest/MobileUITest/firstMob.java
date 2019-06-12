package SystemTest.MobileUITest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class firstMob {

    private  WebDriver driver;
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "iPhone 5");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
    }


    @Test
    public void testAppiumOnChrome() {
        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
