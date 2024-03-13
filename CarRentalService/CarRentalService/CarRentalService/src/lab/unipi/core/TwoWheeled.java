package lab.unipi.core;

public class TwoWheeled extends Vehicle {
	
	//Arxikopoihsh twn fields
	double seatHeight;
	String baggageSystem;
	
	
	//Constructor
	public TwoWheeled(double seatHeight, String baggageSystem, String licensePlate, String model, String gasOrPetrol, String type, String volume, double rentalPerDay){
		//O super constructor mpainei giati h klash klhronomei apo thn Vehicle
		super(licensePlate, model, gasOrPetrol, type, volume, rentalPerDay);
		this.seatHeight = seatHeight;
		this.baggageSystem = baggageSystem;
	}

	//Getters kai Setters
	public double getSeatHeight() {
		return seatHeight;
	}

	public void setSeatHeight(double seatHeight) {
		this.seatHeight = seatHeight;
	}

	public String getBaggageSystem() {
		return baggageSystem;
	}

	public void setBaggageSystem(String baggageSystem) {
		this.baggageSystem = baggageSystem;
	}
	
	
	
	
}
