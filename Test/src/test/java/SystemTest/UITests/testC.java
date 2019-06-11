package SystemTest.UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;

public class testC {
    @Test
    public void main(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        List<WebElement> list = driver.findElements(By.tagName("a"));
        for(WebElement e : list){
            System.out.println(e.getText());
        }
        driver.quit();
    }
}
