package SystemTest.UITests;

import org.testng.annotations.Test;
import ControlImplementation.PageObjects.GooglePage;
import ControlImplementation.PageObjects.ImdbPage;
import ControlImplementation.PageObjects.WikiPage;
import ControlImplementation.UIControls.BrowserControl;
import ControlImplementation.Utilities.ExcelDataReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class testC {
    private BrowserControl control = new BrowserControl();
    private WebDriver driver;
    
    @DataProvider
    public static Object[][] ReadExcelData() throws IOException {
        Object[][] obj = null;
        try {
            obj = ExcelDataReader.ReadExcelData("D:\\TestAutothon\\src\\test\\java\\TestData", "Movies.xlsx", "data");
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }


    @Test (dataProvider = "ReadExcelData")
    public void main(Hashtable<String, String> data) {
    	control.start("chrome");
        driver = control.getDriver();   
        GooglePage googlePage = new GooglePage(driver);
        String movieName =data.get("MovieName");
        System.out.println(movieName);
        googlePage.enterQuery(movieName);
        String wiki = googlePage.searchWikiLink(movieName);
        WikiPage wikiPage = new WikiPage(driver);
        String director = wikiPage.getDirectorName(wiki);
        System.out.println(director);
        
        ImdbPage imdbPage = new ImdbPage(driver);
        String imdbLink = wikiPage.getImdbLink();
        System.out.println(imdbLink);
        String imDir = imdbPage.getImdbDirector(imdbLink);
        System.out.println(imDir);
        googlePage.setFilm_Director(movieName, director + " Imdb : " + imDir);
        
        driver.quit();
    }
    


    @AfterTest
    public void close() {
    	GooglePage googlePage = new GooglePage(driver);
        Map<String,String> filmDir = googlePage.getFilm_Director();
    	for (Map.Entry<String,String> entry : filmDir.entrySet()){  
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); }
    	driver.quit();
    }
}
