package Week2.day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.chrome.chromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		String driverpath = System.getProperty("webdriver.chrome.driver");
		System.out.println(driverpath);
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Kamal");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kannadassan");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9884256057");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Abcdef@1234");
		WebElement eleAt1 = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select dd1 = new Select(eleAt1);
		dd1.selectByValue("5");
		WebElement eleAt2 = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select dd2 = new Select(eleAt2);
		dd2.selectByValue("9");
		WebElement eleAt3 = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select dd3 = new Select(eleAt3);
		dd3.selectByValue("1982");
		driver.findElement(By.xpath("//label[contains(text(),'Female')]/following-sibling::input")).click();
		
		
		
	}

}
