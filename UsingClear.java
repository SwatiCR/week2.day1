package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingClear {

	public static void main(String[] args) {
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

		//first name(local)
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("swat");

		//department field
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("cse");

		//description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Computer science department");

		//email id
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("swaticr@gmail.com");

		//state province drop down
		//check for drop down source
		WebElement stateProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));

		//convert to select class
		Select selectClassVar = new Select(stateProvince);

		//select by visible text
		selectClassVar.selectByVisibleText("Armed Forces Pacific");

		//Click Submit button
		driver.findElement(By.className("smallSubmit")).click();

		//Verify the Verify Lead Page Title
		String title = driver.getTitle();

		if (title.equals("View Lead | opentaps CRM")) {
			System.out.println("View Lead Page verified");
		}
		
		//Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//clear company name
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		
		//enter new company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CTS");
		
		//clear first name
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		
		//enter new first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Shiva");
		
		//create lead submit
		driver.findElement(By.className("smallSubmit")).click();
		
		//verify the lead page title
		String title2 = driver.getTitle();
		
		if (title2.equals("View Lead | opentaps CRM")) {
			System.out.println("View Lead Page verified after duplicate lead");
		}
	}

}
