package SystemTest.MobileUITest;


import ControlImplementation.UIControls.BrowserControl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firstMob {

    private  WebDriver driver;
    @BeforeTest
    public void setUp() {
        BrowserControl control = new BrowserControl();
        control.start("chrome","iPad");
        driver = control.getDriver();
    }


    @Test
    public void testOnIphone() throws Exception{
        driver.get("https://amazon.com");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // This  will scroll down the page by  1000 pixel vertical
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
