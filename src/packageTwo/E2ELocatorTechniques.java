package packageTwo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2ELocatorTechniques {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String name = "John";

		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		String Password = getPassword(driver);

		// Catch the error with invaid login credentials
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		// Forgot your password
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Name\"]")).sendKeys("Rahul");
		driver.findElement(By.cssSelector("input[placeholder=\"Email\"]")).sendKeys("Rahul123");
		// driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); //indexing
		// on xpath
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("0987654325"); // indexing on CssSelector
		driver.findElement(By.xpath("//div/button[2]")).click(); // xpath with tags
		System.out.println(driver.findElement(By.cssSelector("form p")).getText()); // CssSelector with tags

		// Login with valid credentials
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder*='Password']")).sendKeys(Password); // regular expressions with CssSelector
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.className("signInBtn")).click();

		// User logged in
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.cssSelector("h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Hello " + name + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/button[2]")).click();
		String Password = driver.findElement(By.cssSelector("form p")).getText();
		String[] splitPswrdOne = Password.split("'");
		String actualPassword = splitPswrdOne[1].split("'")[0];

		return actualPassword;
	}

}