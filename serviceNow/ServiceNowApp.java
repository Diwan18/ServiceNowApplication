package serviceNow;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNowApp {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://dev242606.service-now.com/");
		driver.get("https://dev186929.service-now.com/");
//		driver.get("https://dev216320.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
//		driver.findElement(By.id("user_password")).sendKeys("v^S8PbUx1J^k");
		driver.findElement(By.id("user_password")).sendKeys("2AqjN!lC2!Vy");
//		driver.findElement(By.id("user_password")).sendKeys("UY2mOUe^7p@");
		driver.findElement(By.id("sysverb_login")).click();
		
		Thread.sleep(5000);
		
		Shadow S = new Shadow(driver);
		WebElement Shadow = S.findElementByXPath("//div[@aria-label='All']");
		Thread.sleep(5000);
		Shadow.click();
		Thread.sleep(10000);
		Shadow S1 = new Shadow(driver);
		WebElement Shadow2 = S1.findElementByXPath("//span[text()='Service Catalog']");
		Shadow2.click();
		
		Thread.sleep(5000);
		
		Shadow S2 = new Shadow(driver);
		WebElement iframe = S2.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframe);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//table[@class='drag_section_header']/tbody/tr/td/a[text()='Mobiles']")).click();
		Thread.sleep(5000);
		

		driver.findElement(By.xpath("(//table[@aria-label='Category Items']/tbody/tr/td)[3]/div//a")).click();
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("(//table[@role='presentation']/tbody/tr/td)[11]//span/label")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@name='IO:4afecf4e9747011021983d1e6253af34']")).sendKeys("99");
		Thread.sleep(5000);
		
		WebElement DD = driver.findElement(By.xpath("//select[@name='IO:ff1f478e9747011021983d1e6253af68']"));
		Select phno = new Select(DD);
		phno.selectByIndex(2);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//label[text()='Sierra Blue']")).click();
		
		driver.findElement(By.xpath("//label[contains(text(),'512 GB')]")).click();
		
		
		driver.findElement(By.xpath("//button[@name='oi_order_now_button']")).click();
		
		
		String orderMessage = driver.findElement(By.xpath("//span[contains(text(),'Thank you')]")).getText();
		
		System.out.println(orderMessage);
		
		if (orderMessage.contains("Thank")) {
			System.out.println("Order placed is Verified");
		}
		
		String ReqNum = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		
		System.out.println(ReqNum);
		
		File ScrnShot = driver.getScreenshotAs(OutputType.FILE);
		
		File trg = new File("./ScrnShot/img.png");
		
		FileUtils.copyFile(ScrnShot, trg);
		
		driver.quit();
		
	}

}
