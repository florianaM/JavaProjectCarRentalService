package lab.unipi.core;


public class City {
	
	//Arxikopoihsh twn fields
	private int cityCode;
	private String cityName;
	static int MAX_CODE=0;
	
	
	//Constructor
	public City(String cityName){
		MAX_CODE++;
		this.cityCode = MAX_CODE;
		this.cityName = cityName;
		
	}

	
	//Getters kai Setters
	public int getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
