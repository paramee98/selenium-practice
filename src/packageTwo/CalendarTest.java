package packageTwo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		String date = "6";
		String month = "4";
		String year = "2027";
		String[] expectedDate = { month, date, year };

		driver.findElement(By.className("react-date-picker__inputGroup")).click();
		driver.findElement(By.xpath("//button/span")).click();
		driver.findElement(By.xpath("//button/span")).click();
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
				.get(Integer.parseInt(month) - 1).click();
		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

		List<WebElement> values = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for (int i = 0; i < values.size(); i++) {
			System.out.println(values.get(i).getAttribute("value"));
			Assert.assertEquals(values.get(i).getAttribute("value"), expectedDate[i]);
		}

	}

}
