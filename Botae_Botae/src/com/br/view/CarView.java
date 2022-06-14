package com.br.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.br.controller.CarController;
import com.br.model.vo.Car;
import com.br.model.vo.Stores;

public class CarView {
	
	Scanner sc = new Scanner(System.in);
	CarController cc = new CarController();
	
	
	public void mainMenu() {
		
		
		while(true) {
			System.out.println("\n========== 보태보태 차량고르기 프로그램 ==========");
			
			System.out.println("1.입력받은 조건에 맞는 차량추천");
			System.out.println("2.차량 이름으로 구매 가능한 영업소 조회");
			System.out.println("3.친절별점이 높은 영업소 차량 조회");
			System.out.println("4.자동차 가격순 조회");
			System.out.println("5.내 예산에 맞는 차량 조회");
			System.out.println("6.차량 상담예약");
			System.out.println("7.상담예약 취소");
			System.out.println("8.관리자메뉴");
			System.out.println("0.프로그램 종료");
			int menu = sc.nextInt();
			 sc.nextLine();
			switch(menu) {
			case 1 : qualified(); break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			case 6 : break;
			case 7 : break;
			case 8 : break;
			case 0 : System.out.println("다음에 돈 더 보태서 오세요! 보태보태!");return;
			default : break;
			}
		}
		
	}
	
	//------------------------------------------------------------------------------------//
	
	public void qualified() {
		
		System.out.println("\\n========== 원하는 조건을 골라주세요! ==========");
		System.out.println("1.차량타입으로 고르기 (경차 / 세단 / SUV)");
		System.out.println("2.차량 가격대로 고르기");
		System.out.println("3.연료로 고르기");
		System.out.println("4.국산차 / 외제차 별조회");
		System.out.println("5.브랜드로 고르기");
		System.out.println("0. 이전메뉴로 돌아가기");
		int menu = sc.nextInt();
		sc.nextLine();
		
		switch(menu) {
		case 1 : System.out.print("차량 타입 : ");
				 String carType = sc.nextLine();
				 cc.askCarType(carType);
				 break;
				 /*
		case 2 : System.out.print("가격대('n천만원대'로 입력) : ");
				 String price = sc.nextLine();
				 cc.askPrice(price);
				 break;
		case 3 : System.out.print("연료 (가솔린 / 디젤 / 전기 / 수소)  : ");
				 String fuel = sc.nextLine();
				 cc.askFuel(fuel);
				 break;
		case 4 : System.out.print("국산차 / 외제차 : ");
				 String nation = sc.nextLine();
				 cc.askNation(nation);
				 break;
		case 5 : System.out.print("브랜드 : ");
				 String brand = sc.nextLine();
				 cc.askBrand(brand);
				 break;*/
		case 0 : mainMenu();
		default : System.out.println("잘못 누르셨습니다. 프로그램을 종료합니다."); return;
		}
		
	}
	
	
	public void wantToBuy(ArrayList<Car> list) {
		System.out.println("해당 차량 중 구매를 원하시는 차량이 있나요?");
		System.out.print("1. 예   |   2. 아니오");
		int yesOrNo = sc.nextInt();
		sc.nextLine();
		
		if(yesOrNo == 1) {
			System.out.print("원하시는 차량 이름을 알려주세요 : ");
			String name = sc.nextLine();
			cc.askCarName(name);
		} else {
			System.out.println("차량을 다시 골라보세요.");
			qualified();
		}
		
	}
	
	//------------------------------------------------------------------------------------//
	
	public void displayFail(String messege) {
		System.out.println(messege + "다시 시도해주세요.");
	}
	
	public void displayList(ArrayList<Car> list) {
		System.out.println("차량이름\t차량타입\t가격\t연료\t생산\t브랜드");
		for(Car c : list) {
			System.out.println(c);
		}
		wantToBuy(list);
	}
	
	public void displayStore(Stores s, String name ) {
		System.out.println(name + "차량 구매 가능한 영업소 : ");
		System.out.println("영업소이름\t영업소번호\t서비스점수\t주소");
		System.out.println(s);
	
	}
	

}
















