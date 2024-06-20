package ian.project.main.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataUtil {
	
	private Long firstNumber, secondNumber;
	private static String build;
	
	public DataUtil() throws FileNotFoundException, IOException, ParseException {
		initializeData();
	}
	
	public Long getFirstNumber() {
		return firstNumber;
	}

	public Long getSecondNumber() {
		return secondNumber;
	}
	
	public String getBuild() {
		return build;
	}

	private void initializeData() throws FileNotFoundException, IOException, ParseException {
		String jsonPath = System.getProperty("user.dir") + File.separator 
				+ "src/test/resources/testdata/calculator.json";
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(jsonPath));
		for (Object o : jsonArray) {
			JSONObject data = (JSONObject) o;
			build = (String) data.get("build");
			this.firstNumber = (Long) data.get("first number");
			this.secondNumber = (Long) data.get("second number");
		}
	}
}
