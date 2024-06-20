package ian.project.main.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Calculator {
	
	private DataUtil data;
	private Long firstNumber, secondNumber;

	public Calculator() throws FileNotFoundException, IOException, ParseException {
		this.data = new DataUtil();
		this.firstNumber = data.getFirstNumber();
		this.secondNumber = data.getSecondNumber();
	}
	
	public Long getFirstNumber() {
		return firstNumber;
	}

	public Long getSecondNumber() {
		return secondNumber;
	}

	public Long getSum() {
		return firstNumber + secondNumber;
	}
	
	public Long getDifference() {
		return firstNumber - secondNumber;
	}
	
	public Long getProduct() {
		return firstNumber * secondNumber;
	}
	
	public Long getQuotient() {
		return firstNumber / secondNumber;
	}
	
	public String concatenate() {
		return firstNumber.toString() + secondNumber.toString();
	}
}
