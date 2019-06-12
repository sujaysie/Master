package SystemTest.UITests;

import ControlImplementation.UIControls.BrowserControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class testC {
    @Test
    public void main(){
        BrowserControl control = new BrowserControl();
        control.start("chrome");
        WebDriver driver = control.getDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        List<WebElement> list = driver.findElements(By.tagName("a"));
        for(WebElement e : list){
            System.out.println(e.getText());
        }
        driver.quit();
    }
}
