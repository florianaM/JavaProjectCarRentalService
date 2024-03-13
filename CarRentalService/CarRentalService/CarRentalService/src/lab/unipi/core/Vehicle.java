package lab.unipi.core;

public class Vehicle {
	
	//Arxikopoihsh twn fields
	public String licensePlate;
	private String model;
	private String gasOrPetrol;
	private String type;
	private String volume;
	private double rentalPerDay;
	
	
	//Constructor
	public Vehicle(String licensePlate, String model, String gasOrPetrol, String type, String volume, double rentalPerDay) {
		this.licensePlate = licensePlate;
		this.model = model;
		this.gasOrPetrol = gasOrPetrol;
		this.type = type;
		this.volume = volume;
		this.rentalPerDay = rentalPerDay;
	}

	
	//Getters kai Setters
	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getGasOrPetrol() {
		return gasOrPetrol;
	}

	public void setGasOrPetrol(String gasOrPetrol) {
		this.gasOrPetrol = gasOrPetrol;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public double getRentalPerDay() {
		return rentalPerDay;
	}

	public void setRentalPerDay(double rentalPerDay) {
		this.rentalPerDay = rentalPerDay;
	}
	
	
	
	//TWO WHEELED
	public double getSeatHeight() {
		return 0;
	}

	public void setSeatHeight(double seatHeight) {
	}

	
	public String getBaggageSystem() {
		return "-";
	}

	public void setBaggageSystem(String baggageSystem) {
	}
	
	
	
	//CAR
	public int getSeatsNumber() {
		return 0;
	}

	public void setSeatsNumber(int seatsNumber) {
	}

	
	public int getDoorsNumber() {
		return 0;
	}

	public void setDoorsNumber(int doorsNumber) {
	}
}
