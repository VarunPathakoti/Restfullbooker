import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.GetBooking;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.io.IOException;
public class CreateToken extends Utils{
	String token;
	String bookId;
	Testdata data = new Testdata();
	Response res;
	@Test
	public void authToken() throws IOException {
		token = given().spec(requestSpecification()).body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}").when().post("/auth")
		.then().log().all().extract().response().asString();
		
		JsonPath jp = new JsonPath(token);
		System.out.println(jp.getString("token"));
	}
	//@Test
	public void getBookingIds() throws IOException {
		given().spec(requestSpecification()).when().get("/booking").then().log().all().extract().response();
	}
	
	@Test
	public void getBooking() throws IOException {
		
		GetBooking bookingResponse =  given().spec(requestSpecification()).pathParam("bookid", bookId) .get("booking/{bookid}").as(GetBooking.class);
		System.out.println(bookingResponse.getDepositpaid());
		System.out.println(bookingResponse.getBookingdates().getCheckin());
	}
	
	@Test
	public void createBooking() throws IOException {
 	res =given().spec(requestSpecification()).body(data.createBooking("Pinky", "junior"))
		.when().post("/booking");
 	bookId = getJsonPath(res,"bookingid");
		System.out.println(bookId);
	}
}
