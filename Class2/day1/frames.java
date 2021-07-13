package Class2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frames {

	public static void main(String[] args) {
		
		// //button[@id = 'Click']
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("http://leafground.com/pages/frame.html"));
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		
		
		// To come out of the current frame/ reach the main dcument
		driver.switchTo().defaultContent();
		
		// Nested Frame
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click1")).click();driver.switchTo().frame(0);
		
		driver.findElement(By.id("Click")).click();
		
		
		
	}

}
