package test;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class APITest {

	@Test
	public void getCall() {
		RestAssured
		.given().log().all()
		.get("https://api.instantwebtools.net/v1/airlines/1")
		.then()
		.log().all()
		.statusCode(201);
	}
}
