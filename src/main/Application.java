package main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import generated.NewDataSet;
import generated.NewDataSet.Holidays;

/**
 * @author William Wen
 *
 */
public class Application {
	public static final String REST_URL = "http://www.holidaywebservice.com/Holidays/HolidayService.asmx/GetHolidaysForYear?countryCode=US&year=2016";
	public static final int OK_STATUS = Response.Status.OK.getStatusCode();
	private static final String XML_FILE_NAME = "GetHolidaysForYear.xml";

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// Call the service and get the response object.

		// Section 03. Write a REST Client
		// Lecture 10. Call a Holiday XML Service
		// Response oResponse = ClientBuilder.newClient()
		// .target(REST_URL)
		// .request(MediaType.APPLICATION_XML)
		// .get();

		try {
			// Get an unmarshaller
			JAXBContext oJaxbContext;
			oJaxbContext = JAXBContext.newInstance("generated");
			Unmarshaller oUnmarshaller = oJaxbContext.createUnmarshaller();
			
			// Build a DOM
			DocumentBuilderFactory oDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
			oDocumentBuilderFactory.setNamespaceAware(true);
			DocumentBuilder oDocumentBuilder = oDocumentBuilderFactory.newDocumentBuilder();
			Document oDocument = oDocumentBuilder.parse(new File(XML_FILE_NAME));
			
			// Traverse the DOM until "NewDataSet" is reached.
			Element oElement = oDocument.getDocumentElement();
			Node oNode = oElement.getElementsByTagName("NewDataSet")
					.item(0);
			
			// Unmarshal "NewDataSet"
			JAXBElement<NewDataSet> oJaxbElement = oUnmarshaller.unmarshal(oNode, NewDataSet.class);
			
			// Print the holidays
			List<Holidays> oHolidays = oJaxbElement.getValue()
					.getHolidays();
			
			for (Holidays oHoliday : oHolidays) {
				System.out.printf("%30s: %d/%d/%d\n", oHoliday.getName(), oHoliday.getDate()
						.getMonth(), oHoliday.getDate()
						.getDay(), oHoliday.getDate()
						.getYear());
			}
			

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Caught Exception: " + e.getMessage());
		}

		// Process the response object

		// Section 03. Write a REST Client
		// Lecture 10. Call a Holiday XML Service
		// StatusType oStatusType = oResponse.getStatusInfo();
		// int oStatusCode = oStatusType.getStatusCode();
		// if (oStatusCode == OK_STATUS) {
		// System.out.println(oResponse.readEntity(String.class));
		// } else {
		// System.out.printf("Service returned status: \"%d %s\"\n"
		// , oStatusCode
		// , oStatusType.getReasonPhrase());
		// }

	}

}