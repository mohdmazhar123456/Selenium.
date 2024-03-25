package Expr;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exp0 {

	public static void main(String[] args) throws InterruptedException {



//			WebDriver driver = new EdgeDriver();
			WebDriver driver= new ChromeDriver();
//			WebDriver driver= new FirefoxDriver();  
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://demo.campuscare.cloud");
	
		    System.out.println(driver.getTitle());
		    System.out.println(driver.getCurrentUrl());
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("9045785274");
		    Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("GCAGUZ");

			Thread.sleep(3000);
			driver.findElement(By.xpath("(//i[@class='fas fa-angle-right'])[1]")).click();
			
			try {
				Alert alert = driver.switchTo().alert();
	            String alertMessage = alert.getText();
	            System.out.println("Alert message: " + alertMessage);
	            
			Thread.sleep(3000);
		//	driver.findElement(By.xpath("//input[@id='UserOtpText']")).sendKeys("123456");
	//		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
//			driver.findElement(By.xpath("//button[text()='Verify']")).click();

			
			
			
		}
		catch(Exception e) {
			System.out.println("No alert present.");
		}
		
			 // Assuming now the OTP alert appears, we pause the execution
	        // and prompt the user to manually input the OTP
	        System.out.println("Please enter the OTP manually:");
	        Scanner scanner = new Scanner(System.in);
	        String otp = scanner.nextLine(); // Read OTP from user input

	        // Locate the OTP field and fill it with the entered OTP
	        WebElement otpField = null;
	        try {
	            // You need to replace "otpFieldId" with the actual ID of the OTP field
	            otpField = driver.findElement(By.xpath("//input[@id='UserOtpText']"));
	            otpField.sendKeys(otp); // Fill OTP field with user input 
	            driver.findElement(By.xpath("//button[text()='Verify']")).click();
	        } catch (Exception e) {
	            System.out.println("Error: OTP field not found.");
	            e.printStackTrace();
	        }

	        // Close the browser
//	        driver.quit();
		

	}

}
