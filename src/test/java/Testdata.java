import pojo.CreateBookingDetailspojo;
import pojo.CreateBookingpojo;

public class Testdata {
	
	public CreateBookingpojo createBooking(String fname, String lname) {
		CreateBookingpojo booking = new CreateBookingpojo();
		booking.setFirstname(fname);
		booking.setLastname(lname);
		booking.setTotalprice(111);
		booking.setDepositpaid("true");
		CreateBookingDetailspojo details = new CreateBookingDetailspojo();
		details.setCheckin("2024-01-01");
		details.setCheckout("2024-05-01");
		booking.setBookingdates(details);
		booking.setAdditionalneeds("lunch");
		
		return booking;
	}
	
	public String updatePayload() {
		return "{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown_updated\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"freeBreakfast\"\r\n"
				+ "}";
	}
	public String partialupdatePayload() {
		return "{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown\"\r\n"
				+ "}";
	}

}
