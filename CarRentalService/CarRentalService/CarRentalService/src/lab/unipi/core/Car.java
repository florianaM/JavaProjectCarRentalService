package lab.unipi.core;

public class Car extends Vehicle {
	
	//Arxikopoihsh twn fields
	private int seatsNumber;
	private int doorsNumber;
	
	//Constructor
	public Car(int seatsNumber, int doorsNumber, String licensePlate, String model, String gasOrPetrol, String type, String volume, double rentalPerDay) {
		//O super constructor mpainei giati h klash klhronomei apo thn Vehicle
		super(licensePlate, model, gasOrPetrol, type, volume, rentalPerDay);
		this.seatsNumber = seatsNumber;
		this.doorsNumber = doorsNumber;
	}

	//Getters kai Setters
	public int getSeatsNumber() {
		return this.seatsNumber;
	}

	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}

	public int getDoorsNumber() {
		return this.doorsNumber;
	}

	public void setDoorsNumber(int doorsNumber) {
		this.doorsNumber = doorsNumber;
	}
	
}
