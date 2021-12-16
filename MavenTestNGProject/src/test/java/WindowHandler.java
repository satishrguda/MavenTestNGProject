import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandler {

	@Test
	public void WindowOperations(){
		String projPath = System.getProperty("user.dir");
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", projPath+"\\chromedriver.exe");
		driver.get("https://demoqa.com/browser-windows");
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.id("windowButton")).click();
		driver.switchTo().window(mainWindow);	
		driver.findElement(By.id("windowButton")).click();
		Set <String> s1 = driver.getWindowHandles();
		Iterator <String> it = s1.iterator();
		while(it.hasNext()) {
			String child = it.next();
			if(!mainWindow.equals(child)) {
				driver.switchTo().window(child);
				System.out.println("You're in Child Window" + " " + driver.findElement(By.id("sampleHeading")).getText());
			}
		}
		System.out.println("You're in Parent Window" + " " + driver.getWindowHandle());
		driver.quit();
	}
}