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
	
	

}
