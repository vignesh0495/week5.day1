package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{
	
    @Test (enabled = false)
	public void duplicateLead() throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		// Capture name of First Resulting lead
				String leadName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"))
						.getText();
				System.out.println("Lead name is : " + leadName);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		// Verify the title as 'Duplicate Lead'
				if (driver.getTitle().contains("Duplicate Lead"))
					System.out.println("Duplicate Lead Page Title confirmed");
				else
					System.out.println("Duplicate Lead Page Title not confirmed");

				// Click Create Lead
				driver.findElement(By.className("smallSubmit")).click();

				// Confirm the duplicated lead name is same as captured name
				if (driver.findElement(By.id("viewLead_firstName_sp")).getText().equalsIgnoreCase(leadName))
					System.out.println("Duplicated Lead Name = Captured Name");
				else
					System.out.println("Duplicated Lead Name != Captured Name");

		driver.findElement(By.name("submitButton")).click();
		driver.close();
}
}






