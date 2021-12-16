import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TabHandler {

	@Test
	public void TabOperations() {
		String projPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projPath+"//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		driver.findElement(By.id("tabButton")).click();
		driver.switchTo().window(parent);
		driver.findElement(By.id("tabButton")).click();
		Set <String> handles = driver.getWindowHandles();
		Iterator <String> it = handles.iterator();

		while(it.hasNext()) {
			String child = it.next();
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
				System.out.println("You're in new tab " +driver.getWindowHandle());
			}
		}
		driver.quit();
	}

}
