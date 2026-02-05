package packageTwo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Rahul");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("rahul123@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Rahul987@@");
		driver.findElement(By.id("exampleCheck1")).click();
		
		//*******
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select option = new Select(dropdown);
		option.selectByVisibleText("Female");
		//driver.findElement(By.xpath("//option[2]")).click();
		//*******
		
		driver.findElement(By.cssSelector("#inlineRadio1")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("12/12/2025");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
	
	}
	
}
