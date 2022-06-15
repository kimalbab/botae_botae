package com.br.controller;

import java.util.ArrayList;

import com.br.model.service.CarService;
import com.br.model.vo.Car;
import com.br.model.vo.Reserve;
import com.br.model.vo.Stores;
import com.br.view.CarView;

public class QualifiedCarController {
	

	//---------------- qualified() 메소드 ---------------//
	public void askCarType(String carType) {
		ArrayList<Car> list = new CarService().askCarType(carType);
		
		if(list.isEmpty()) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayList(list);
		}
		
	}
	
	public void askPrice(String price) {
		
		char charPrice = 0;
		int intPrice = 0;
		int [] priceArr = new int [2]; 
		
		if(price.length() == 5) {
			charPrice = price.charAt(0);
			intPrice = Character.getNumericValue(charPrice);
		} else {
			for (int i=0; i<2; i++) {
				priceArr[i] = Character.getNumericValue(price.charAt(i));
			}
			intPrice = (priceArr[0] * 10) + (priceArr[1]);
		}
		
		ArrayList <Car> list = new CarService().askPrice(intPrice);
		
		if(list.isEmpty()) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayList(list);
		}
		
	}
	
	
	public void askFuel(String fuel) {
		
		ArrayList<Car> list = new CarService().askFuel(fuel);
		
		if(list.isEmpty()) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayList(list);
		}
	}
	
	public void askNation(String nation) {
		ArrayList <Car> list = new CarService().askNation(nation);
		
		if(list.isEmpty()) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayList(list);
		}
	}
	
	public void askBrand(String brand) {
		
		if(brand.contains("기아")) {
			brand = "KIA";
		} 
		
		ArrayList <Car> list = new CarService().askBrand(brand);
		
		if(list.isEmpty()) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayList(list);
		}
	}
	
	
	
	
	

}
