package api.practice;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostApiTest {

	@Test(enabled = false)
	public void postPassengerPrettyPrintTest() {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body("{\"name\": \"David Miller\",\"trips\": 151,\"airline\": 1}")
		.post("https://api.instantwebtools.net/v1/passenger")
		.prettyPrint();
	}
	
	@Test(enabled = false)
	public void postPassengerTestWithFile() {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/passenger.json"))
		.post("https://api.instantwebtools.net/v1/passenger")
		.then()
		.log().all()
		.statusCode(200)
		.body("airline.id", hasItem(4))
		.body("airline.name", hasItem("Emirates"))
		.body("airline.website[0]", equalTo("www.emirates.com/"));
	}
	
	
	@Test(enabled = false)
	public void postPassengerTestWithFileAsInputStream() {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("passenger.json"))
		.post("https://api.instantwebtools.net/v1/passenger")
		.then()
		.log().all()
		.statusCode(200)
		.body("airline.id", hasItem(4))
		.body("airline.name", hasItem("Emirates"))
		.body("airline.website[0]", equalTo("www.emirates.com/"));
	}
	
	@Test(enabled = true)
	public void postPassengerTestWithFileAsByteArray() throws IOException {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("passenger.json").readAllBytes())
		.post("https://api.instantwebtools.net/v1/passenger")
		.then()
		.log().all()
		.statusCode(200)
		.body("airline.id", hasItem(4))
		.body("airline.name", hasItem("Emirates"))
		.body("airline.website[0]", equalTo("www.emirates.com/"));
	}
	
	
	@Test(enabled = false)
	public void postPassengerTestWithMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Anik Khan");
		map.put("trips", 101);
		map.put("airline", 4);
		
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(map)
		.post("https://api.instantwebtools.net/v1/passenger")
		.then()
		.log().all()
		.statusCode(200)
		.body("airline.id", hasItem(4))
		.body("airline.name", hasItem("Emirates"))
		.body("airline.website[0]", equalTo("www.emirates.com/"));
	}
}
