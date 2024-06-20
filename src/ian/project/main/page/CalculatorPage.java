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
	}
	
	private void inputNumbers(String firstNumber, String secondNumber) {
		driver.findElement(By.id(CalculatorPageLocators.BTN_CLEAR_ID)).click();
		
		driver.findElement(By.id(CalculatorPageLocators.TXT_FIRSTNUMBER_ID)).sendKeys(firstNumber);
		driver.findElement(By.id(CalculatorPageLocators.TXT_SECONDNUMBER_ID)).sendKeys(secondNumber);
	}

	public long performAdd(String firstNumber, String secondNumber) {
		inputNumbers(firstNumber, secondNumber);
		
		Select obj = new Select(driver.findElement(By.id(CalculatorPageLocators.SEL_OPERATION_ID)));
		obj.selectByVisibleText("Add");
		
		driver.findElement(By.id(CalculatorPageLocators.BTN_CALC_ID)).click();
		util.waitForPageToLoad();
		
		return Long.parseLong(driver.findElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID)).getText());
	}

	public long performSubtract(String firstNumber, String secondNumber) {
		inputNumbers(firstNumber, secondNumber);
		
		Select obj = new Select(driver.findElement(By.id(CalculatorPageLocators.SEL_OPERATION_ID)));
		obj.selectByVisibleText("Subtract");
		
		driver.findElement(By.id(CalculatorPageLocators.BTN_CALC_ID)).click();
		util.waitForPageToLoad();
		
		return Long.parseLong(driver.findElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID)).getText());
	}

	public long performMultiply(String firstNumber, String secondNumber) {
		inputNumbers(firstNumber, secondNumber);
		
		Select obj = new Select(driver.findElement(By.id(CalculatorPageLocators.SEL_OPERATION_ID)));
		obj.selectByVisibleText("Multiply");
		
		driver.findElement(By.id(CalculatorPageLocators.BTN_CALC_ID)).click();
		util.waitForPageToLoad();
		
		return Long.parseLong(driver.findElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID)).getText());
	}

	public long performDivide(String firstNumber, String secondNumber) {
		inputNumbers(firstNumber, secondNumber);
		
		Select obj = new Select(driver.findElement(By.id(CalculatorPageLocators.SEL_OPERATION_ID)));
		obj.selectByVisibleText("Divide");
		
		driver.findElement(By.id(CalculatorPageLocators.BTN_CALC_ID)).click();
		util.waitForPageToLoad();
		
		return Long.parseLong(driver.findElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID)).getText());
	}

	public String concatenate(String firstNumber, String secondNumber) {
		inputNumbers(firstNumber, secondNumber);
		
		Select obj = new Select(driver.findElement(By.id(CalculatorPageLocators.SEL_OPERATION_ID)));
		obj.selectByVisibleText("Concatenate");
		
		driver.findElement(By.id(CalculatorPageLocators.BTN_CALC_ID)).click();
		util.waitForPageToLoad();
		
		return driver.findElement(By.id(CalculatorPageLocators.TXT_ANSWER_ID)).getText();
	}
	
	
}
