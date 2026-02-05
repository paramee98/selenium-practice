package packageTwo;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWebLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		int linksCount = driver.findElements(By.tagName("a")).size();
		System.out.println(linksCount);

		WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // Limiting webdriver scope
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		WebElement columnDriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); // Limiting footerDriver
																								// scope
		System.out.println(columnDriver.findElements(By.tagName("a")).size());

		// click on each link in the coloumn and check if the pages are opening
		for (int i = 0; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
			String clickOnLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);

		}

		// getting the titles of each child tabs
		Set<String> titles = driver.getWindowHandles();
		Iterator<String> it = titles.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
