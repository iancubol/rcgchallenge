package ian.project.main.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUtil {

	private WebDriver driver;
	protected WebDriverWait wdw;

	public HelperUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForPageToLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                // This will tell if page is loaded
                return "complete".equals(((JavascriptExecutor) wd).executeScript("return document.readyState"));
            }
        };
        try {
        	Thread.sleep(2000);
        	WebDriverWait wait = new WebDriverWait(driver, 30);
        	// Wait for page complete
        	wait.until(pageLoadCondition);
        } catch (Throwable error) {
        	System.out.println("Page loading timed out...");
        }
	}
}
