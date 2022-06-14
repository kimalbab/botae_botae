package com.br.controller;

import java.util.ArrayList;

import com.br.model.service.CarService;
import com.br.model.vo.Car;
import com.br.model.vo.Stores;
import com.br.view.CarView;

public class CarController {
	
	public void askCarType(String carType) {
		ArrayList<Car> list = new CarService().askCarType(carType);
		
		if(list.isEmpty()) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayList(list);
		}
		
	}
	
	public void askCarName(String name) {
		Stores s = new CarService().askCarName(name);
		
		if(s == null) {
			new CarView().displayFail("차량 조회 실패");
		} else {
			new CarView().displayStore(s, name);
		}
		
	}

}
