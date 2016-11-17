package main;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;

/**
 * Parses a JSON file containing a USD to EUR exchange rate from
 * http://rate-exchange.appspot.com
 *
 * @author William Wen
 *
 */
public class JSONMain {

	private static final String JSON_FILE_NAME = "rate-exchange.json";

	/**
	 * Parse and display the JSON file.
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		// Get the JSON file.
		JsonParser oJsonParser = Json.createParser(new FileReader(JSON_FILE_NAME));
		
		// Parse the file.
		while (oJsonParser.hasNext()) {
			JsonParser.Event oJsonParserEvent = oJsonParser.next();
			if (oJsonParserEvent.equals(JsonParser.Event.KEY_NAME)) {
				String oKey = oJsonParser.getString();
				System.out.printf("Key: %s, ", oKey);
				oJsonParser.next();
				String oValue = oJsonParser.getString();
				System.out.printf("Value: %s\n", oValue);
			}
			
		}
	}
}
