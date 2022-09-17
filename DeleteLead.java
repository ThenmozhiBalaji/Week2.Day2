package Week2.day2;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.chrome.chromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("91");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9884256057");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		String FirstLeadID = ele.getText();
		//Click First Resulting lead
		ele.click();
		
		//Click Delete & Then click on Find Leads
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//Enter captured lead ID  & Click find leads button
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(FirstLeadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		Thread.sleep(10000);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Records deleted successfully");
		} else {
			System.out.println("Record is not deleted");
		}
//		WebElement deleted = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]"));
//		String deletedId = deleted.getText();
//		driver.findElement(By.xpath("//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]//a[1]")).click();
//		driver.findElement(By.xpath("//a[text()='Delete']")).click();
//		driver.findElement(By.xpath("//a[contains(text(), \"Find Leads\")]")).click();
//		driver.findElement(By.xpath("//input[@name=\"id\"]")).sendKeys(deletedId);
//		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
//		String alrt = driver.findElement(By.xpath("//div[@class='x-panel-bbar']//div[text()='No records to display']")).getText();
//		System.out.println(alrt+ " records verified");
//		driver.close();
//		if(driver.findElement(By.xpath("//div[@class=\"x-paging-info\"]")).getText().equals("No records to display")) {
//			System.out.println("Successfully Deleted!");
//		}
//		else {
//			System.out.println("Error: not deleted!");
//		}
	}

}
