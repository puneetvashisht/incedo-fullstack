package microservices.reservationbookingservice;


public class ReservationBookingBean {
	
	private int id;
    
	private String source;
    
	private String destination;
	
	private double price;
	
	private String environment;
	
	private double totalPrice;

	public ReservationBookingBean() {
		super();
	}

	public ReservationBookingBean(int id, String source, String destination, double price, double totalPrice) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ReservationBookingBean [id=" + id + ", source=" + source + ", destination=" + destination + ", price="
				+ price + ", totalPrice=" + totalPrice + "]";
	}
	
}
