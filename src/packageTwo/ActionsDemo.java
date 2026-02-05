package packageTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");

		Actions a = new Actions(driver);

		// mouse hover
		WebElement move = driver.findElement(By.xpath("//span[@class='gh-my-ebay__link gh-rvi-menu']"));
		a.moveToElement(move).build().perform();

		// enter capital letters
		WebElement keyword = driver.findElement(By.xpath("//input[@title='Search']"));
		a.moveToElement(keyword).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

		// right click on any particular element
		a.moveToElement(move).contextClick().build().perform();

	}

}
