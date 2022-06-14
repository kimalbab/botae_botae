package com.br.model.vo;

public class Reserve {
	
	private int reserveNo;
	private String cusName;
	private String cusTel;
	private String carName;
	
	public Reserve() {
		
	}

	public Reserve(int reserveNo, String cusName, String cusTel, String carName) {
		super();
		this.reserveNo = reserveNo;
		this.cusName = cusName;
		this.cusTel = cusTel;
		this.carName = carName;
	}

	public int getReserveNo() {
		return reserveNo;
	}

	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusTel() {
		return cusTel;
	}

	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	@Override
	public String toString() {
		return "Reserve [reserveNo=" + reserveNo + ", cusName=" + cusName + ", cusTel=" + cusTel + ", carName="
				+ carName + "]";
	}
	
	

}
