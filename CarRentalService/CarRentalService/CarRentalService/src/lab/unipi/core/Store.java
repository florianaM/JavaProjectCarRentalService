package lab.unipi.core;

public class Store {
	
	//Arxikopoihsh twn fields
	private int storeCode;
	private String storeName;
	private String storeCity;
	static int MAX_CODE=0;
	
	
	//Constructor
	public Store(String storeName, String storeCity){
		MAX_CODE++;
		this.storeCode = MAX_CODE;
		this.storeName = storeName;
		this.storeCity = storeCity;
	}

	
	//Getters kai Setters
	public int getStoreCode() {
		return this.storeCode;
	}

	public void setStoreCode(int storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreCity() {
		return this.storeCity;
	}

	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}
	

	public String toString() {	  
        return new String ("Store Information:"+"\n"+"Code:"+this.getStoreCode() +"\n"+"Store Name:"+this.getStoreName()+ "Store City:"+ this.getStoreCity());
 }
}
