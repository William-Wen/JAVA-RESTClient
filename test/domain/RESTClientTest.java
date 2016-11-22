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

}
