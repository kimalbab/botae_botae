package com.br.controller;

import java.util.ArrayList;

import com.br.model.service.CarService;
import com.br.model.vo.Car;
import com.br.model.vo.Reserve;
import com.br.model.vo.Stores;
import com.br.model.vo.Users;
import com.br.view.CarView;

public class CarController {
	
	//CarView cv = new CarView();
	
		public int priceConvert(String price) {
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
			return intPrice;
		}
		
		public ArrayList<Car> comparePrice(ArrayList<Car> list, int intPrice) {
			ArrayList <Car> newList = new ArrayList<>();
			
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getPrice().contains(Integer.toString(intPrice))) {
					newList.add(list.get(i));
				}
			}
			
			return list;
		}
		
		public void searchStars() {
			ArrayList <Stores> list = new CarService().searchStars();
			
			if(list.isEmpty()) {
				new CarView().displayFail("매장 조회 실패");
			} else {
				new CarView().displayStoreList(list);
			}
		}
		
		public void orderByPrice() {
			ArrayList<Car> list = new CarService().orderByPrice();
			ArrayList<Car> newList = new ArrayList<>();
			
			
			// 리스트를 금액따라 배열해줘야함!!!//
			
			if(list.isEmpty()) {
				new CarView().displayFail("차량 조회 실패");
			} else {
				for(int i=0; i<list.size(); i++) {
					int intPrice = new CarController().priceConvert(list.get(i).getPrice());
					
					/* 일단 여기서 스탑!
					list.Add(new Car());
					
					newList.addAll(list);
					*/	
				}
				new CarView().displayList(list);
			}
			
		}
		
		public void myBudjet(String budjet) {
			new QualifiedCarController().askPrice(budjet);
		}
		
		public void cancelReserve(String cusName) {
			int result = new CarService().cancleReserve(cusName);
			
			if(result > 0) {
				new CarView().displaySuccess("\n" + cusName + "님의 예약이 취소되었습니다.");
			} else {
				new CarView().displayFail("\n예약실패! 다시 시도해주세요.");
			}
		}
	
	//---------------- qualified() 이후 주문메소드 ---------------//
	
	


		public void reserveCarName(String carName) {
			Stores s = new CarService().askCarName(carName);
			
			if(s == null) {
				new CarView().displayFail("차량 조회 실패");
			} else {
				new CarView().displayStore(s, carName);
				new CarView().reserve(carName);
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
		
		
		public void login(Users u) {
			ArrayList<Reserve> list = new CarService().login(u);
			if(list.isEmpty()) {
				new CarView().displayFail("조회할 상담예약이 없습니다.");
			} else {
				new CarView().displayReserveList(list);
			}
		}
	

}
