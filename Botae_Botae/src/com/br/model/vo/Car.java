package com.br.model.vo;

public class Car {
	
	private int carNo;
	private String carName;
	private String carType;
	private String price;
	private String fuel;
	private String nation;
	private String brand;
	private String storeId;
	private int intPrice;
	
	public Car() {
		
	}

	public Car(int carNo, String carName, String carType, String price, String fuel, String nation, String brand,
			String storeId) {
		super();
		this.carNo = carNo;
		this.carName = carName;
		this.carType = carType;
		this.price = price;
		this.fuel = fuel;
		this.nation = nation;
		this.brand = brand;
		this.storeId = storeId;
	}
	
	public Car(String carName, String carType, String price, String fuel, String nation, String brand) {
		//super();
		this.carName = carName;
		this.carType = carType;
		this.price = price;
		this.fuel = fuel;
		this.nation = nation;
		this.brand = brand;
	}
	
	public Car(String carName, String carType,  String price, String fuel, String nation, String brand, int intPrice) {
		//super();
		this.carName = carName;
		this.carType = carType;
		this.price = price;
		this.fuel = fuel;
		this.nation = nation;
		this.brand = brand;
		this.intPrice = intPrice;
	}
	
	public Car(String carName, String carType,  int intPrice, String fuel, String nation, String brand) {
		//super();
		this.carName = carName;
		this.carType = carType;
		this.intPrice = intPrice;
		this.fuel = fuel;
		this.nation = nation;
		this.brand = brand;
	}
	
	public Car(String carName, String carType, String price, String fuel, String nation, String brand, String storeId) {
		//super();
		this.carName = carName;
		this.carType = carType;
		this.price = price;
		this.fuel = fuel;
		this.nation = nation;
		this.brand = brand;
		this.storeId = storeId;
	}

	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getIntPrice() {
		return intPrice;
	}

	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	/*
	@Override
	public String toString() {
		return  carName + "			\t" + carType + "\t" + price + "\t" + fuel + "			\t" + nation + "\t" +  brand;
	}*/

	
	@Override
	public String toString() {
		return "차량조회정보 [   차량이름 : " + carName + "   |   차량타입 : " + carType + "   |   가격 : " + price + "   |   연료 : "
				+ fuel + "   |   제조 : " + nation + "   |   브랜드 : " + brand + "   ]";
	}


	public String toStringIntPrice() {
		return "차량조회정보 [   차량이름 : " + carName + "   |   차량타입 : " + carType + "   |   가격 : " + intPrice + "   |   연료 : "
				+ fuel + "   |   제조 : " + nation + "   |   브랜드 : " + brand + "   ]";
	}

}
	 
	


