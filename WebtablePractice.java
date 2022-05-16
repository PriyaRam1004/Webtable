package automationpractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebtablePractice {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\thiru\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.ibm.com/docs/en/i/7.4?topic=tables-employee-table-employee");
		WebElement table = driver.findElement(By.xpath("//table[@class='bx--data-table']"));
		List<WebElement> header = table.findElements(By.tagName("th"));
		for (WebElement head : header) {
			String text = head.getText();
			System.out.println("The Head of The Table: " + text);
		}
		List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
		int size = rows.size();
		System.out.println(size);
		for (WebElement row1 : rows) {
			List<WebElement> data = row1.findElements(By.tagName("td"));
			WebElement colums = data.get(0);
			System.out.println(colums.getText());
		}
		driver.quit();
	}

}
