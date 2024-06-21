package ian.project.main.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Calculator {
	
	private DataUtil data;
	private Integer firstNumber, secondNumber;

	public Calculator() throws FileNotFoundException, IOException, ParseException {
		this.data = new DataUtil();
		this.firstNumber = data.getFirstNumber();
		this.secondNumber = data.getSecondNumber();
	}
	
	public Integer getFirstNumber() {
		return firstNumber;
	}

	public Integer getSecondNumber() {
		return secondNumber;
	}

	public Integer getSum() {
		return firstNumber + secondNumber;
	}
	
	public Integer getDifference() {
		return firstNumber - secondNumber;
	}
	
	public Integer getProduct() {
		return firstNumber * secondNumber;
	}
	
	public Double getQuotient() {
		return (double) firstNumber / (double) secondNumber;
	}
	
	public String concatenate() {
		return firstNumber.toString() + secondNumber.toString();
	}

	public String getBuild() {
		return data.getBuild();
	}
}
