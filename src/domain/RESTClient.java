package domain;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class RESTClient {

	// REST Service Constants
	private static final String REST_URL = "http://localhost/RESTServices/rs";
	private static final int SERVER_PORT = 8080;
	private static final String PATH = "foods";

	// ivars
	private WebTarget oWebTarget;

	/**
	 * Set up the connection.
	 */
	public RESTClient() {
		URI oUri;
		Client oClient;

		// create the URL.
		oUri = UriBuilder.fromUri(REST_URL)
				.port(SERVER_PORT)
				.build();

		// create a client.
		oClient = ClientBuilder.newClient();

		// create a target.
		oWebTarget = oClient.target(oUri)
				.path(PATH);

	}

	public Response getAll(String mediaType) {
		return oWebTarget.request(mediaType)
				.get();
	}
	
	public Response get(String food, String mediaType) {
		return oWebTarget.path(food)
				.request(mediaType)
				.get();
	}
	
	public Response post(String name, int calories, String servingSize) {
		Food oFood = new Food(name, calories, servingSize);
		Entity<Food> oEntityFood = Entity.entity(oFood, MediaType.APPLICATION_XML);
		return oWebTarget.request()
				.post(oEntityFood);
	}
	
	public Response put(String name, int calories, String servingSize) {
		Food oFood = new Food(name, calories, servingSize);
		Entity<Food> oEntityFood = Entity.entity(oFood, MediaType.APPLICATION_XML);
		return oWebTarget.request()
				.put(oEntityFood);
	}
	
	public Response delete(String name) {
		return oWebTarget.path(name)
				.request()
				.delete();
	}

}


























