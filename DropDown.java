package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// We have to call WDM for the browser driver		
		WebDriverManager.chromedriver().setup();

		//Launch the browser
		ChromeDriver driver = new ChromeDriver();		

		//Load the URL
		driver.get("http://leaftaps.com/opentaps");

		//Maximize the browser
		driver.manage().window().maximize();

		//close browser
		//driver.close();

		//find the user name
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		//find the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//click the login button
		driver.findElement(By.className("decorativeSubmit")).click();

		//To check if we are on the correct page
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));

		//get the attribute and print
		String attribute = logout.getAttribute("value");
		System.out.println(attribute);

		if (attribute.equals("Logout")){
			System.out.println("Successfully logged in");
		}
				
		//Click CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click Leads Link
		driver.findElement(By.linkText("Leads")).click();
		
		//Click Create Lead Link
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter Company Name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		
		//Enter First Name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Swati");
				
		//Enter Last Name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("CR");
		
		//Check for Drop Down SOurce
		WebElement dropdown1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		//Convert to Select
		Select select = new Select(dropdown1);
		
		//Select selectByVisibleText
		select.selectByVisibleText("Conference");
		
		//Select selectByValue
		select.selectByValue("LEAD_WEBSITE");
		
		//Select selectByIndex
		select.selectByIndex(1);
		
	}

}
