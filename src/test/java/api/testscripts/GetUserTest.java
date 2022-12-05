package api.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.GetUsersEnpoint;

public class GetUserTest {

	GetUsersEnpoint getUsers;
	
	@BeforeMethod
	public void init() {
		getUsers = new GetUsersEnpoint();
	}
	
	@Test
	public void getUsersTest() {
		getUsers.getUsers();
		getUsers.statusCodeValidation();
		getUsers.responseBodyValidation("data.last_name[2]", "Funke");
		getUsers.responseBodyValidation("data.first_name[1]", "Lindsay");
	}
}
