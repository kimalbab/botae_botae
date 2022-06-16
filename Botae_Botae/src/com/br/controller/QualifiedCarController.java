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

		int intPrice = new CarController().priceConvert(price);
		ArrayList <Car> list = new CarService().askPrice(intPrice);
		//ArrayList<Car> newList = new CarController().comparePrice(list, intPrice);

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
