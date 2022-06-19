package com.br.controller;

import java.util.ArrayList;
import java.util.Collections;

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
			ArrayList<Car> list = new CarService().orderBy();
			ArrayList<Car> alterList = new ArrayList<Car>();
			
			// 리스트를 금액따라 배열해줘야함!!!//
			
			if(list.isEmpty()) {
				new CarView().displayFail("차량 조회 실패");
			} else {
				
				for(Car c : list) {
					int getPrice = priceConvert(c.getPrice());
					String getPriceStr = "" + getPrice + "";
					c.setPrice(getPriceStr);
				}
				
				for(int i=0; i<list.size(); i++) {
					alterList.get(i).setCarName(list.get(i).getCarName());
					alterList.get(i).setCarType(list.get(i).getCarType());
					alterList.get(i).setIntPrice(Integer.parseInt(list.get(i).getPrice()));
					alterList.get(i).setFuel(list.get(i).getFuel());
					alterList.get(i).setNation(list.get(i).getNation());
					alterList.get(i).setBrand(list.get(i).getBrand());
				}
				
				// 생각해보니 이 리스트들은 오라클에 없이 자바에서만 공유되고 있는 리스트여서
				// service, dao 쪽으로 옮기지 않아도 된다!
				//ArrayList<Car> newList = new CarService().orderByPrice(alterList); 
				

				new CarView().displayList(alterList);
				
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
