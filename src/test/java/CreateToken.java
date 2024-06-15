import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.GetBooking;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.io.IOException;
public class CreateToken extends Utils{
	String tokenid;
	String bookId;
	String tokenVal;
	 String cookieValue;
	Testdata data = new Testdata();
	Response res;
	@Test(priority=1)
	public void authToken() throws IOException {
		tokenid = given().spec(requestSpecification()).body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}").when().post("/auth")
		.then().log().all().extract().response().asString();
		
		JsonPath jp = new JsonPath(tokenid);
		//System.out.println(jp.getString("token"));
		tokenVal=jp.getString("token");
	}
	//@Test
	public void getBookingIds() throws IOException {
		given().spec(requestSpecification()).when().get("/booking").then().log().all().extract().response();
	}
	
	@Test(priority=3)
	public void getBooking() throws IOException {
		
		GetBooking bookingResponse =  given().spec(requestSpecification()).pathParam("bookid", bookId) .get("booking/{bookid}").as(GetBooking.class);
		System.out.println(bookingResponse.getDepositpaid());
		System.out.println(bookingResponse.getBookingdates().getCheckin());
	}
	
	@Test(priority=2)
	public void createBooking() throws IOException {
 	res =given().spec(requestSpecification()).body(data.createBooking("Pinky", "junior"))
		.when().post("/booking");
 	bookId = getJsonPath(res,"bookingid");
		System.out.println(bookId);
	}
	
	@Test(priority=4)
	public void updateBooking() throws IOException {
		
		   cookieValue = "token="+tokenVal;
		  
		  System.out.println(cookieValue);
		 
		res = given().spec(requestSpecification()).pathParam("bid", bookId).header("Cookie",cookieValue)
			.body(data.updatePayload())	
		.when().put("/booking/{bid}");
		String lname = getJsonPath(res,"lastname");
		System.out.println(lname);
		
	}
	@Test(priority=5)
	public void partialpdateBooking() throws IOException {
		
		   cookieValue = "token="+tokenVal;
		  
		  System.out.println(cookieValue);
		 
		res = given().spec(requestSpecification()).pathParam("bid", bookId).header("Cookie",cookieValue)
			.body(data.partialupdatePayload())	
		.when().patch("/booking/{bid}");
		String lname = getJsonPath(res,"lastname");
		System.out.println(lname);
		
	}
	@Test(priority = 6)
	public void deleteBooking() throws IOException {
		res = given().spec(requestSpecification()).pathParam("bid", bookId).header("Cookie",cookieValue)
				.when().delete("booking/{bid}");
	}
}
