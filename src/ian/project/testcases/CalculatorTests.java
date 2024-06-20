package ian.project.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ian.project.main.page.CalculatorPage;
import ian.project.main.utils.Calculator;
import ian.project.main.utils.HelperUtil;

public class CalculatorTests extends MainTest {

	private Calculator calculator;
	private CalculatorPage calcPage;
	private HelperUtil util;
	
	public CalculatorTests() throws FileNotFoundException, IOException, ParseException {
		this.calculator = new Calculator();
		this.calcPage = new CalculatorPage(driver);
		this.util = new HelperUtil(driver);
	}
	
	@Test
	public void performOperations() {
		util.waitForPageToLoad();
		
		String firstNumber = calculator.getFirstNumber().toString();
		String secondNumber = calculator.getSecondNumber().toString();
		
		long expectedValue = 0;
		long actualValue = 0;
		
		//add
		expectedValue = calculator.getSum();
		actualValue = calcPage.performAdd(firstNumber, secondNumber);
		Assert.assertEquals(actualValue, expectedValue);
		
		//subtract
		expectedValue = calculator.getDifference();
		actualValue = calcPage.performSubtract(firstNumber, secondNumber);
		Assert.assertEquals(actualValue, expectedValue);
		
		//multiply
		expectedValue = calculator.getProduct();
		actualValue = calcPage.performMultiply(firstNumber, secondNumber);
		Assert.assertEquals(actualValue, expectedValue);
		
		//divide
		expectedValue = calculator.getQuotient();
		actualValue = calcPage.performDivide(firstNumber, secondNumber);
		Assert.assertEquals(actualValue, expectedValue);
		
		//concatenate
		Assert.assertEquals(calcPage.concatenate(firstNumber, secondNumber), 
				calculator.concatenate());
	}
	 
}
