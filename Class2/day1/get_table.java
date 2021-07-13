package Class2.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class get_table {
	
	// Best to get the lowest value

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/table.html");
		
		driver.manage().window().maximize();
		
		//WebElement full_table = driver.findElement(By.id("table_id"));
		
		 //List <WebElement> all_table_datas = full_table.findElements(By.tagName("tr"));
		 		
		//int all_rows = all_table_datas.size();
		
		//System.out.println(all_rows);
		
		//====================================
		
		WebElement all_rows = driver.findElement(By.id("table_id"));
		
		List <WebElement> all_rows_data = all_rows.findElements(By.tagName("tr"));
		
		int size = all_rows_data.size();
		
		//System.out.println(size);
		
		String rows_name = all_rows_data.get(1).getText();
		
		//String heading = rows_name.getText();
		
		//System.out.println(rows_name);
		
		List<Integer> check_values = new ArrayList<Integer>();
		
		for(int i = 1; i<size; i++) {
			
			WebElement table_rows = all_rows_data.get(i);
			
			List <WebElement> table_datas = table_rows.findElements(By.tagName("td"));
			
			String print_values = table_datas.get(1).getText().replaceAll("%", "");
			
			// int i=Integer.parseInt("200");  
			
			check_values.add(Integer.parseInt(print_values));
			
			Collections.sort(check_values);
			
			System.out.println(check_values);
			
			Integer lowest = check_values.get(0);
			
			driver.findElement(By.xpath("//td[contains(text(),'"+lowest+"')]/following-sibling::td/input")).click();
			
			
			
			
		}
		
	}

}
