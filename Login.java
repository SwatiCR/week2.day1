package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

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
		
	/*	01_ Launch, maximize
		02_ Login to application
		03_ Click CRM/SFA Link
		04_ Click Leads Link
		05_ Click Create Lead Link
		06_ Enter Company Name
		07_ Enter First Name
		08_ Enter Last Name
		09_ Click Submit button
		10_ Verify the Verify Lead Page Title
		*/

	}

}
