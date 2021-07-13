package Class2.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firstprogram {
	
	// class room assignment

public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver = new ChromeDriver();
	
	//Load the URL
	
	driver.get("https://erail.in/");
	
	//Maximize screen
	
	driver.manage().window().maximize();

	driver.findElement(By.id("txtStationFrom")).clear();
	
	driver.findElement(By.id("txtStationFrom")).sendKeys("ms");
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//div[text() = 'Chennai Egmore']")).click();
	
	driver.findElement(By.id("txtStationTo")).clear();
	
	driver.findElement(By.id("txtStationTo")).sendKeys("mdu");
	
	
	
	driver.findElement(By.xpath("//div[text() = 'Madurai Jn']")).click();
	
	driver.findElement(By.id("chkSelectDateOnly")).click();
	Thread.sleep(1000);
	//DataTable TrainList TrainListHeader
	
	WebElement Web_table = driver.findElement(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']"));
	 
	List<WebElement> Table_rows = Web_table.findElements(By.tagName("tr"));
	
	Thread.sleep(4000);
					
	String all_train_number = Table_rows.get(1).getText();
	
	System.out.println(all_train_number);




}

}
