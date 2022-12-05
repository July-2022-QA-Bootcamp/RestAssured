package api.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.PassengerEndpoint;

public class GetPassengerTest {

	PassengerEndpoint passenger;
	
	@BeforeMethod
	public void init() {
		passenger = new PassengerEndpoint();
	}
	
	@Test
	public void testGetPassenger() {
		passenger.getPassenger();
		passenger.statusCodeValidation();
		passenger.responseBodyValidation("totalPassengers", 5);
	}
}
