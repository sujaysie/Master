package ControlImplementation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImdbPage {

	private WebDriver driver;

	public ImdbPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getImdbDirector(String url) {
		String dirName = "No name";
		try {
			driver.get(url);
			List<WebElement> credits = driver.findElements(By.cssSelector("div[class='credit_summary_item']"));
			for (WebElement credit : credits) {
				if (credit.findElement(By.tagName("h4")).getText().startsWith("Director:")) {
					dirName = credit.findElement(By.tagName("a")).getText();
					break;
				}
			}
		} catch (Exception e) {

		}
		return dirName;

	}
}
