import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks {
	@Test
	public void ValidateLinks() throws Exception, IOException {
		int respCode=0;
		String url = "";
		HttpURLConnection huc = null;
		String projPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projPath+"//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		List <WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while(it.hasNext()){
			url = it.next().getAttribute("href");
			huc = (HttpURLConnection)(new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			respCode = huc.getResponseCode();
			if(respCode >= 400){
				System.out.println(url+" is a broken link");
			}
		}
	}
}
