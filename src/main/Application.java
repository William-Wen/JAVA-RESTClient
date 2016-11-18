package main;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

/**
 * @author William Wen
 *
 */
public class Application {
	public static final String REST_URL = "http://www.holidaywebservice.com/Holidays/HolidayService.asmx/GetHolidaysForYear?countryCode=US&year=2016";
	public static final int OK_STATUS = Response.Status.OK.getStatusCode();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Call the service and get the response object.
		Response oResponse = ClientBuilder.newClient()
				.target(REST_URL)
				.request(MediaType.APPLICATION_XML)
				.get();

		// Process the response object
		StatusType oStatusType = oResponse.getStatusInfo();
		int oStatusCode = oStatusType.getStatusCode();
		if (oStatusCode == OK_STATUS) {
			System.out.println(oResponse.readEntity(String.class));
		} else {
			System.out.printf("Service returned status: \"%d %s\"\n"
					, oStatusCode
					, oStatusType.getReasonPhrase());
		}
		
	}

}
