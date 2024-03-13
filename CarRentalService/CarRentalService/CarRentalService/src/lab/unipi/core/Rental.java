package lab.unipi.core;

public class Rental {
	
	//Arxikopoihsh twn fields
	private int rentalCode;
	private String rentedVehicle;
	private String rentingClient;
	private String rentingStore;
	private String pickUpDate;
	private String pickUpHour;
	private String returningStore;
	private String returnDate;
	private String returnHour;
	private int totalCost;
	private static int MAX_CODE=0;
	
	//Constructor
	public Rental(String rentedVehicle, String rentingClient, String rentingStore, String pickUpDate,String pickUpHour, String returningStore, String returnDate, String returnHour, int totalCost) {	
		MAX_CODE++;
		this.rentalCode = MAX_CODE;
		this.rentedVehicle = rentedVehicle;
		this.rentingClient = rentingClient;
		this.rentingStore = rentingStore;
		this.pickUpDate = pickUpDate;
		this.pickUpHour = pickUpHour;
		this.returningStore = returningStore;
		this.returnDate = returnDate;
		this.returnHour = returnHour;
		this.totalCost = totalCost;
	}

	
	//Getters kai Setters
	public int getRentalCode() {
		return this.rentalCode;
	}

	public void setRentalCode(int rentalCode) {
		this.rentalCode = rentalCode;
	}

	public String getRentedVehicle() {
		return this.rentedVehicle;
	}

	public void setRentedVehicle(String rentedVehicle) {
		this.rentedVehicle = rentedVehicle;
	}

	public String getRentingClient() {
		return this.rentingClient;
	}

	public void setRentingClient(String rentingClient) {
		this.rentingClient = rentingClient;
	}

	public String getRentingStore() {
		return this.rentingStore;
	}

	public void setRentingStore(String rentingStore) {
		this.rentingStore = rentingStore;
	}

	public String getPickUpDate() {
		return this.pickUpDate;
	}

	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public String getPickUpHour() {
		return this.pickUpHour;
	}

	public void setPickUpHour(String pickUpHour) {
		this.pickUpHour = pickUpHour;
	}

	public String getReturningStore() {
		return this.returningStore;
	}

	public void setReturningStore(String returningStore) {
		this.returningStore = returningStore;
	}

	public String getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnHour() {
		return this.returnHour;
	}

	public void setReturnHour(String returnHour) {
		this.returnHour = returnHour;
	}

	public int getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
}
