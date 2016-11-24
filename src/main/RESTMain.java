package main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

/**
 * Calls the RESTful web service at REST_URL defined below.
 * 
 * @author William Wen
 *
 */
public class RESTMain {
//	public static final String REST_URL = "https://currency-api.appspot.com/api/USD/EUR.json";
	
	
	public static final String REST_URL = "http://localhost:8080/RESTServices/rs/foods";
	public static final int OK_STATUS = Response.Status.OK.getStatusCode();

	private static final String oUserName = "tuser";
	private static final String oUserPassword = "tuser";
	
	/**
	 * Call the web service and display the response.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		// setup
//		Client oClient = ClientBuilder.newBuilder()
//				.build();
		
		// authentication setup
		HttpAuthenticationFeature oHttpAuthenticationFeature =
				HttpAuthenticationFeature.basic(oUserName, oUserPassword);
		Client oClient = ClientBuilder.newBuilder()
				.register(oHttpAuthenticationFeature)
				.build();
		
		// call the service and get the response object.
		Response oResponse = oClient.target(
				REST_URL)
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
