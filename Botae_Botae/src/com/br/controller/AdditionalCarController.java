package com.br.controller;

import java.util.ArrayList;


import com.br.model.vo.Car;
import com.br.view.CarView;

public class AdditionalCarController {
	
	
	public void askCarType(String carType, ArrayList<Car> list) {
		
		ArrayList <Car> newList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getCarType().contains(carType)) {
				newList.add(list.get(i));
			}
		}
		
		if(newList.isEmpty()) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayList(newList);
		}
		
	}

	public void askPrice(String price, ArrayList<Car> list) {
		
		int intPrice = new CarController().priceConvert(price);
		ArrayList<Car> newList = new CarController().comparePrice(list, intPrice);
		
		if(newList.isEmpty()) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayList(newList);
		}
		
	}

	public void askFuel(String fuel, ArrayList<Car> list) {
		ArrayList <Car> newList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getFuel().contains(fuel)) {
				newList.add(list.get(i));
			}
		}
		
		if(newList.isEmpty()) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayList(newList);
		}
	}

	public void askNation(String nation, ArrayList<Car> list) {
		ArrayList <Car> newList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNation().contains(nation)) {
				newList.add(list.get(i));
			}
		}
		
		if(newList.isEmpty()) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayList(newList);
		}
	}

	public void askBrand(String brand, ArrayList<Car> list) {
		if(brand.contains("기아")) {
			brand = "KIA";
		} 
		ArrayList <Car> newList = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBrand().contains(brand)) {
				newList.add(list.get(i));
			}
		}
		
		if(newList.isEmpty()) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayList(newList);
		}
	}
	

}




