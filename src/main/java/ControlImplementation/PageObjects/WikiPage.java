package ControlImplementation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sun.glass.events.KeyEvent;

import java.awt.Robot;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WikiPage {
	private WebDriver driver;

	public WikiPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getDirectorName(String wikiLink) {
		String dirName = "None";
		try {
			driver.get(wikiLink);
			dirName = this.getValue("Directed by");

		} catch (Exception e) {

		}
		return dirName;
	}

	public Map movieAndDirectors() {
		Map dir_movie = new HashMap<>();
		try {

		} catch (Exception e) {

		}
		return dir_movie;
	}

	private String getValue(String key) {
		String value = "None";
		try {
			List<WebElement> rows = driver.findElements(By.tagName("tr"));
			for (WebElement row : rows) {
				try {
					if (row.findElement(By.tagName("th")).getText().equalsIgnoreCase(key)) {
						value = row.findElement(By.tagName("td")).getText();
						break;
					}
				} catch (Exception e) {
					System.out.println("Pic");
				}
			}
		} catch (Exception e) {

		}
		return value;
	}

	public String getImdbLink() {
		String link = "no link";
		try {
			WebElement extLink = driver.findElement(By.id("External_links"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", extLink);
			List<WebElement> externalLinks = extLink.findElement(By.xpath("../following-sibling::ul")).findElements(By.tagName("li"));
			for (WebElement externamLink : externalLinks) {
				try {
					if (externamLink != null) {
//
						if (externamLink.findElement(By.tagName("a")).getAttribute("href").startsWith("https://www.imdb.com")) {
							link = externamLink.findElement(By.tagName("a")).getAttribute("href");
							break;
						}
					}
				} catch (org.openqa.selenium.NoSuchElementException e) {
					System.out.println("Nahi mila!");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return link;
	}
}
