package ian.project.testcases;

import java.io.File;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class MainTest {
	protected ChromeDriver driver;

	public void init(final String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator 
				+ "src/test/resources/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

	@BeforeSuite
	public void setUp() {
		try {
			init("https://testsheepnz.github.io/BasicCalculator.html#main-body");
		} catch (WebDriverException e) {
			driver.navigate().refresh();
		}
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
