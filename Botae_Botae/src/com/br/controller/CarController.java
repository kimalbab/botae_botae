package com.br.controller;

import java.util.ArrayList;

import com.br.model.service.CarService;
import com.br.model.vo.Reserve;
import com.br.model.vo.Stores;
import com.br.view.CarView;

public class CarController {
	
	CarView cv = new CarView();
		
		public void searchStars() {
			ArrayList <Stores> list = new CarService().searchStars();
			
			if(list.isEmpty()) {
				new CarView().displayFail("매장 조회 실패");
			} else {
				new CarView().displayStoreList(list);
			}
		}
	
	//---------------- qualified() 이후 주문메소드 ---------------//
	
	

		public void reserveCarName(String carName) {
			Stores s = new CarService().askCarName(carName);
			
			if(s == null) {
				new CarView().displayFail("차량 조회 실패");
			} else {
				new CarView().displayStore(s, carName);
				//new CarView().wantToReserve(carName);
			}
			
		}
		
		public void reserve(Reserve r) {
			int result = new CarService().reserve(r);
			
			if(result > 0) {
				new CarView().displaySuccess("\n예약성공!");
			} else {
				new CarView().displayFail("\n예약실패!");
			}
			
		}
		

}
