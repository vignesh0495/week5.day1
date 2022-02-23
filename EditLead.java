package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditLead extends BaseClass{
    @Test (priority = 1, invocationCount = 2, invocationTimeOut=100000L, threadPoolSize=2)
	public void editLead() throws InterruptedException {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.name("submitButton")).click();
		// Confirm the changed name appears
				if (driver.findElement(By.id("viewLead_companyName_sp")).getText().contains("TCS"))
					System.out.println("Changed company name appears");
				else
					System.out.println("Changed company name does not appear");
		driver.close();
}
}






