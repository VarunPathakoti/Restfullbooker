package pojo;

public class CreateBookingpojo {
	private String firstname;
	private String lastname;
	private int totalprice;
	private String depositpaid;
	private CreateBookingDetailspojo bookingdates;
	private String additionalneeds;

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int i) {
		this.totalprice = i;
	}
	public String getDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(String depositpaid) {
		this.depositpaid = depositpaid;
	}
	public CreateBookingDetailspojo getBookingdates() {
		return bookingdates;
	}
	public void setBookingdates(CreateBookingDetailspojo bookingdates) {
		this.bookingdates = bookingdates;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

}
