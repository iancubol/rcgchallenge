package ian.project.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class MainTest {
	protected WebDriver driver;

	public void init(final String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator 
				+ "src/test/resources/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
