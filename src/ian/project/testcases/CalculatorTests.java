package ian.project.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ian.project.main.page.CalculatorPage;
import ian.project.main.utils.Calculator;
import ian.project.main.utils.HelperUtil;

public class CalculatorTests extends MainTest {

	Calculator calculator;
	CalculatorPage calcPage;
	HelperUtil util;
	String firstNumber, secondNumber;
	String expectedValue, actualValue, reportName, build;

	@BeforeSuite
	public void setUp() throws FileNotFoundException, IOException, ParseException {
		try {
			init("https://testsheepnz.github.io/BasicCalculator.html#main-body");
		} catch (WebDriverException e) {
			driver.navigate().refresh();
		}

		this.calculator = new Calculator();
		this.calcPage = new CalculatorPage(driver);
		this.util = new HelperUtil(driver);
		util.waitForPageToLoad();

		firstNumber = calculator.getFirstNumber().toString();
		secondNumber = calculator.getSecondNumber().toString();
		expectedValue = "";
		actualValue = "";
		
		build = calculator.getBuild();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		reportName = "Report_" + formater.format(calendar.getTime()) + "_BUILD-" + build;
	}

	@BeforeMethod
	public void setupBeforeTest() {
		driver.navigate().refresh();
		calcPage.selectBuild(build);
	}

	@AfterMethod
	public void captureTest(ITestResult result) throws InterruptedException {
		Thread.sleep(2000);
		String methodName = result.getName();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/test-output/";
			File destFile = new File((String) reportDirectory + "/screenshots/"
					+ reportName + "/" + methodName + ".png");
			FileUtils.copyFile(scrFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void performAdditionTest() throws FileNotFoundException, IOException, ParseException {
		expectedValue = calculator.getSum().toString();
		actualValue = calcPage.performAdd(firstNumber, secondNumber);
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Test
	public void performSubtractionTest() throws FileNotFoundException, IOException, ParseException {
		expectedValue = calculator.getDifference().toString();
		actualValue = calcPage.performSubtract(firstNumber, secondNumber);
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Test
	public void performMultiplicationTest() throws FileNotFoundException, IOException, ParseException {
		expectedValue = calculator.getProduct().toString();
		actualValue = calcPage.performMultiply(firstNumber, secondNumber);
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Test
	public void performDivisionTest() throws FileNotFoundException, IOException, ParseException {
		expectedValue = calculator.getQuotient().toString().replace(".0", "");
		actualValue = calcPage.performDivide(firstNumber, secondNumber);
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Test
	public void performConcatenationTest() throws FileNotFoundException, IOException, ParseException {
		Assert.assertEquals(calcPage.concatenate(firstNumber, secondNumber), calculator.concatenate());
	}

}
