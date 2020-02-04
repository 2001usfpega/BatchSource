package bank;
import java.util.HashMap;

import dao.CustomerDAOImp;

public class HashMaps {
	CustomerDAOImp dataObject = new CustomerDAOImp();
	HashMap<String, Customers> hashMapCust;
	HashMap<String, Accounts> hashMapAcc; 
	
	HashMaps(){
		this.hashMapCust = dataObject.getCustHashMap();  
		this.hashMapAcc = dataObject.getAccHashMap();; 
	}

	public CustomerDAOImp getDataObject() {
		return dataObject;
	}

	public void setDataObject(CustomerDAOImp dataObject) {
		this.dataObject = dataObject;
	}

	public HashMap<String, Customers> getHashMapCust() {
		return hashMapCust;
	}

	public void setHashMapCust(HashMap<String, Customers> hashMapCust) {
		this.hashMapCust = hashMapCust;
	}

	public HashMap<String, Accounts> getHashMapAcc() {
		return hashMapAcc;
	}

	public void setHashMapAcc(HashMap<String, Accounts> hashMapAcc) {
		this.hashMapAcc = hashMapAcc;
	}
	

}