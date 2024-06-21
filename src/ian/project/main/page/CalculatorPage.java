package ian.project.main.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import ian.project.main.locators.CalculatorPageLocators;
import ian.project.main.utils.HelperUtil;

public class CalculatorPage {
	private WebDriver driver;
	private HelperUtil util;

	public CalculatorPage(WebDriver driver) {
		this.driver = driver;
		this.util = new HelperUtil(driver);
	}
	
	public void selectBuild(String build) {
		Select obj = new Select(driver.findElement(By.id(CalculatorPageLocators.SEL_BUILD_ID)));
		obj.selectByVisibleText(build);
	}

	private void inputNumbers(String firstNumber, String secondNumber) {
		driver.findElement(By.id(CalculatorPageLocators.BTN_CLEAR_ID)).click();
		
		driver.findElement(By.id(CalculatorPageLocators.TXT_FIRSTNUMBER_ID)).clear();
		driver.findElement(By.id(CalculatorPageLocators.TXT_FIRSTNUMBER_ID)).sendKeys(firstNumber);
		driver.findElement(By.id(CalculatorPageLocators.TXT_SECONDNUMBER_ID)).clear();
		driver.findElement(By.id(CalculatorPageLocators.TXT_SECONDNUMBER_ID)).sendKeys(secondNumber);
	}

	public String performAdd(String firstNumber, String secondNumber) {
		inputNumbers(firstNumber, secondNumber);
		
		Select obj = new Select(driver.findElement(By.id(CalculatorPageLocators.SEL_OPERATION_ID)));
		obj.selectByVisibleText("Add");
		
		driver.findElement(By.id(CalculatorPageLocators.BTN_CALC_ID)).click();
		util.waitForElementToHaveAttributeValue(By.id(CalculatorPageLocators.TXT_ANSWER_ID), 5);
		util.highlightElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID));
		
		return driver.findElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID)).getAttribute("value");
	}

	public String performSubtract(String firstNumber, String secondNumber) {
		inputNumbers(firstNumber, secondNumber);
		
		Select obj = new Select(driver.findElement(By.id(CalculatorPageLocators.SEL_OPERATION_ID)));
		obj.selectByVisibleText("Subtract");
		
		driver.findElement(By.id(CalculatorPageLocators.BTN_CALC_ID)).click();
		util.waitForElementToHaveAttributeValue(By.id(CalculatorPageLocators.TXT_ANSWER_ID), 5);
		util.highlightElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID));
		
		return driver.findElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID)).getAttribute("value");
	}

	public String performMultiply(String firstNumber, String secondNumber) {
		inputNumbers(firstNumber, secondNumber);
		
		Select obj = new Select(driver.findElement(By.id(CalculatorPageLocators.SEL_OPERATION_ID)));
		obj.selectByVisibleText("Multiply");
		
		driver.findElement(By.id(CalculatorPageLocators.BTN_CALC_ID)).click();
		util.waitForElementToHaveAttributeValue(By.id(CalculatorPageLocators.TXT_ANSWER_ID), 5);
		util.highlightElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID));
		
		return driver.findElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID)).getAttribute("value");
	}

	public String performDivide(String firstNumber, String secondNumber) {
		inputNumbers(firstNumber, secondNumber);
		
		Select obj = new Select(driver.findElement(By.id(CalculatorPageLocators.SEL_OPERATION_ID)));
		obj.selectByVisibleText("Divide");
		
		driver.findElement(By.id(CalculatorPageLocators.BTN_CALC_ID)).click();
		util.waitForElementToHaveAttributeValue(By.id(CalculatorPageLocators.TXT_ANSWER_ID), 5);
		util.highlightElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID));
		
		return driver.findElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID)).getAttribute("value");
	}

	public String concatenate(String firstNumber, String secondNumber) {
		inputNumbers(firstNumber, secondNumber);
		
		Select obj = new Select(driver.findElement(By.id(CalculatorPageLocators.SEL_OPERATION_ID)));
		obj.selectByVisibleText("Concatenate");
		
		driver.findElement(By.id(CalculatorPageLocators.BTN_CALC_ID)).click();
		util.waitForElementToHaveAttributeValue(By.id(CalculatorPageLocators.TXT_ANSWER_ID), 5);
		util.highlightElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID));
		
		return driver.findElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID)).getAttribute("value");
	}
	
	
}
