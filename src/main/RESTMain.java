package main;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

/**
 * Calls the RESTful web service at REST_URL defined below.
 * 
 * @author William Wen
 *
 */
public class RESTMain {

	public static final String REST_URL = "https://currency-api.appspot.com/api/USD/EUR.json";
	public static final int OK_STATUS = Response.Status.OK.getStatusCode();

	/**
	 * Call the web service and display the response.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// call the service and get the response object.
		Response oResponse = ClientBuilder.newClient().target(
				"https://currency-api.appspot.com/api/USD/EUR.json")
				.request(MediaType.APPLICATION_JSON).get();

		// process the response object.
		StatusType oStatusType = oResponse.getStatusInfo();
		int oStatusCode = oStatusType.getStatusCode();
		if (oStatusCode == OK_STATUS) {
			System.out.println(oResponse.readEntity(String.class));
		} else {
			System.out.printf("Service returned status: \"%d %s \"\n"
					, oStatusCode
					, oStatusType.getReasonPhrase());

		}

	}
}
