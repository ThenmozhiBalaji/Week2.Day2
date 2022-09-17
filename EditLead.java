package Week2.day2;

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


public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		String driverpath = System.getProperty("webdriver.chrome.driver");
		System.out.println(driverpath);
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		//driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input [@class ='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a [text() = 'Leads']")).click();
		driver.findElement(By.xpath("//a[contains(text(), \"Find Leads\")]")).click();
		driver.findElement(By.xpath("//input[@id='ext-gen248']")).sendKeys("Divya");
		driver.findElement(By.xpath("//button[@id='ext-gen334']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]")).click();
		
		if (driver.getTitle().equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Title of the page Verified successfully");
		} else {
			System.out.println("Title of the page is not correct");
		}
		String text1="MS";
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement ele = driver.findElement(By.id("updateLeadForm_companyName"));
		ele.clear();
		ele.sendKeys(text1);
		driver.findElement(By.xpath("//input[@name='submitButton' and @value='Update']")).click();
		String text = driver.findElement(By.xpath("//span[contains(text(),'MS')]")).getText();
		if (text.contains(text1)) {
			System.out.println("Company name updated Successfully");
		} else {
			System.out.println("The Company name not updated");
		}
		driver.close();
		
	}

}
