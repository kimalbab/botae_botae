package com.br.model.vo;

public class Stores {

	private int storeNo;
	private String storeId;
	private String storeName;
	private String storeTel;
	private int stars;
	private String address;
	
	public Stores() {
		
	}

	public Stores(int storeNo, String storeId, String storeName, String storeTel, int stars, String address) {
		super();
		this.storeNo = storeNo;
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeTel = storeTel;
		this.stars = stars;
		this.address = address;
	}
	
	public Stores(String storeName, String storeTel, int stars, String address) {
		super();

		this.storeName = storeName;
		this.storeTel = storeTel;
		this.stars = stars;
		this.address = address;

	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreTel() {
		return storeTel;
	}

	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return storeName + "\t" + storeTel + "\t" + stars + "\t" + address;
	}

	/*
	@Override
	public String toString() {
		return "Stores [storeNo=" + storeNo + ", storeId=" + storeId + ", storeName=" + storeName + ", storeTel="
				+ storeTel + ", stars=" + stars + ", address=" + address + "]";
	}
	*/
	
	
}
