package ControlImplementation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GooglePage {

    private static WebDriver driver;
    private static Map<String,String> film_Director = new HashMap<>();
    public GooglePage(WebDriver driver){
        GooglePage.driver = driver;
    }

    public void enterQuery(String query) {
        try {
            driver.get("https://www.google.com");
            driver.findElement(By.cssSelector("input[class='gLFyf gsfi'")).sendKeys(query);
            driver.findElement(By.cssSelector("input[class='gLFyf gsfi'")).sendKeys(Keys.RETURN);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public String searchWikiLink(String movieName){
        String wikiLink;
        try {
            List<WebElement> searchResults = driver.findElements(By.cssSelector("div[class='g']"));
            for (WebElement searchResult : searchResults) {
                WebElement link = searchResult.findElement(By.tagName("a"));
                wikiLink = link.getAttribute("href");
                String movieNameInWiki = link.findElement(By.tagName("h3")).getText();
                if (wikiLink.startsWith("https://en.wikipedia.org") && movieNameInWiki.contains(movieName)) {
                    return wikiLink;
                }
            }
        }catch (Exception e){
            
        }
        return null;
    }
    

	public Map<String, String> getFilm_Director() {
		return film_Director;
	}

	public void setFilm_Director(Map<String, String> film_Director) {
		GooglePage.film_Director = film_Director;
	}
	public void setFilm_Director(String film, String director) {
		try{
		GooglePage.film_Director.put(film, director);
		}catch(Exception e){
			
		}
	}   
}
