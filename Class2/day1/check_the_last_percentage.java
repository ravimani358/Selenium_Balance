package Class2.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class check_the_last_percentage {
	
	// i do my ownelf

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://leafground.com/pages/table.html");
		
		List<Integer> all_values = new ArrayList<Integer>();
		
		WebElement full_table = driver.findElement(By.id("table_id"));
		
		 List <WebElement> all_table_rows = full_table.findElements(By.tagName("tr"));
		
		 int size = all_table_rows.size();
		 
		 for(int i = 1; i<size; i++) {
			 
			 WebElement all_rows = all_table_rows.get(i);
			 
			 List <WebElement> all_datas = all_rows.findElements(By.tagName("td"));
			 
			 String final_value = all_datas.get(1).getText().replace("%","");
			 
			 //System.out.println(final_value);
			 
			 all_values.add(Integer.parseInt(final_value));
			 			 
			 Collections.sort(all_values);
			 
		 }
		 
		 int lowest = all_values.get(0);
		 
		 driver.findElement(By.xpath("//td[contains(text(),'"+lowest+"')]/following-sibling::td/input")).click();
		 
		
	}

}
