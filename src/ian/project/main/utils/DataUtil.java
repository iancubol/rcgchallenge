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
	
	private Integer firstNumber, secondNumber;
	private String build;
	
	public DataUtil() throws FileNotFoundException, IOException, ParseException {
		initializeData();
	}
	
	public Integer getFirstNumber() {
		return firstNumber;
	}

	public Integer getSecondNumber() {
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
			this.build = (String) data.get("build");
			this.firstNumber = Integer.parseInt((String) data.get("first number"));
			this.secondNumber = Integer.parseInt((String) data.get("second number"));
			
		}
	}
}
