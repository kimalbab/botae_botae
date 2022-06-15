package com.br.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.br.controller.AdditionalCarController;
import com.br.model.vo.Car;

public class AdditionalCarView{
	Scanner sc = new Scanner(System.in);
	AdditionalCarController acc = new AdditionalCarController();
	
	public void qualified(ArrayList<Car> list) {
		System.out.println("\n========== 원하는 조건을 골라주세요! ==========");
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
				 String carType = sc.nextLine().toUpperCase();
				 acc.askCarType(carType, list);
				 break;
			 
		case 2 : System.out.print("가격대('n천만원대'로 입력) : ");
				 String price = sc.nextLine();
				 acc.askPrice(price, list);
				 break;
		case 3 : System.out.print("연료 (가솔린 / 디젤 / 전기 / 수소)  : ");
				 String fuel = sc.nextLine();
				 acc.askFuel(fuel, list);
				 break;
		case 4 : System.out.print("국산차 / 외제차 : ");
				 String nation = sc.nextLine();
				 acc.askNation(nation, list);
				 break;
		case 5 : System.out.print("브랜드 : ");
				 String brand = sc.nextLine().toUpperCase();
				 acc.askBrand(brand, list);
				 break;
		case 0 : System.out.println("돈을 더 보태 와 주세요! 보태보태를 종료합니다."); return;
		default : System.out.println("잘못 누르셨습니다. 다시 골라주세요. "); return;
		
	}
	}
}
