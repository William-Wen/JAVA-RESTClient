package domain;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import utility.Utility;

public class RESTClientTest {


	@Test
	public void getAllTest() {
		// call the web service.
		RESTClient oRestClient = new RESTClient();
		Response oResponse = oRestClient.getAll(MediaType.APPLICATION_XML);
		Utility.printResponse(oResponse);
		
		// test the response.
		assertTrue(Utility.getStatusCode(oResponse) == Utility.OK_STATUS);
	}
	
	private static final String FOOD_NAME = "Beans";
	
	@Test
	public void getTest(){
		// call the web service
		RESTClient oRestClient = new RESTClient();
		Response oResponse = oRestClient.get(FOOD_NAME, MediaType.APPLICATION_JSON);
		Utility.printResponse(oResponse);
		
		// test the response
		int oResponseCode = Utility.getStatusCode(oResponse);
		boolean OK = (oResponseCode == Utility.OK_STATUS);
		boolean NOT_FOUND = (oResponseCode == Utility.NOT_FOUND_STATUS);
		assertTrue(NOT_FOUND || OK); 
		
	}
	
	@Test
	public void postTest() {
		// create a "turnip"
		RESTClient oClient = new RESTClient();
		Response oResponse = oClient.post("turnip", 50, "3 slices");
		Utility.printResponse(oResponse);
		
		// test the response
		int oResponseCode = Utility.getStatusCode(oResponse);
		boolean NOT_MODIFIED = (oResponseCode == Utility.NOT_MODIFIED_STATUS);
		boolean CREATED = (oResponseCode == Utility.CREATED_STATUS);
		assertTrue(NOT_MODIFIED || CREATED);
	}
	
	@Test
	public void putTest() {
		// change the "turnip" properties
		RESTClient oRestClient = new RESTClient();
		Response oResponse = oRestClient.put("turnip", 80, "4 slices");
		Utility.printResponse(oResponse);
		
		// test the response
		assertTrue(Utility.getStatusCode(oResponse) == Utility.OK_STATUS);				
	}
	
	@Test
	public void deleteTest() {
		// delete a "turnip"
		RESTClient oRestClient = new RESTClient();
		Response oResponse = oRestClient.delete("turnip");
		Utility.printResponse(oResponse);
		
		// test the response
		int oResponseCode = Utility.getStatusCode(oResponse);
		boolean NO_CONTENT = (oResponseCode == Utility.NO_CONTENT_STATUS);
		boolean NOT_FOUND = (oResponseCode == Utility.NOT_FOUND_STATUS);
		assertTrue(NOT_FOUND || NO_CONTENT); 
		
	}

}















