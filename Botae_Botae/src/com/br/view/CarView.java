package com.br.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.br.controller.CarController;
import com.br.controller.QualifiedCarController;
import com.br.model.vo.Car;
import com.br.model.vo.Reserve;
import com.br.model.vo.Stores;
import com.br.model.vo.Users;

public class CarView {
	
	Scanner sc = new Scanner(System.in);
	QualifiedCarController qcc = new QualifiedCarController();
	AdditionalCarView acv = new AdditionalCarView();
	CarController cc = new CarController();
	
	public void mainMenu() {
		
		
		while(true) {
			System.out.println("\n========== 보태보태 차량 고르기 프로그램 ==========\n");
			
			System.out.println("1.입력받은 조건에 맞는 차량추천");
			System.out.println("2.차량 이름으로 구매 가능한 영업소 조회");
			System.out.println("3.친절별점이 높은 우수 영업소 차량 조회"); //3번은 보수 필요함!@!
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
			case 2 : cc.reserveCarName(askCarName()); break;
			case 3 : cc.searchStars(); break;
			case 4 : cc.orderByPrice(); break;
			case 5 : askBudjet(); break;
			case 6 : wantToReserve(askCarName()); break;
			case 7 : cancelReserve(); break;
			case 8 : login(); break;
			case 0 : System.out.println("다음에 돈 더 보태서 오세요! 보태보태!");return;
			default : break;
			}
		}
		
	}
	
	//------------------------------------------------------------------------------------//
	
	public void qualified() {
		
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
				 qcc.askCarType(carType);
				 break;
				 
		case 2 : System.out.print("가격대('n'천만원대 숫자만 입력) : ");
				 String price = sc.nextLine();
				 qcc.askPrice(price);
				 break;
		case 3 : System.out.print("연료 (가솔린 / 디젤 / 전기 / 수소)  : ");
				 String fuel = sc.nextLine();
				 qcc.askFuel(fuel);
				 break;
		case 4 : System.out.print("국산차 / 외제차 : ");
				 String nation = sc.nextLine();
				 qcc.askNation(nation);
				 break;
		case 5 : System.out.print("브랜드 : ");
				 String brand = sc.nextLine().toUpperCase();
				 qcc.askBrand(brand);
				 break;
		case 0 : System.out.println("돈을 더 보태 와 주세요! 보태보태를 종료합니다."); return;
		default : System.out.println("잘못 누르셨습니다. 다시 골라주세요. "); return;
		}
		
	}
	

	
	//------------------------------------------------------------------------------------//
	
	public void login() {
		System.out.println("\n\n관리자 메뉴입니다.");
		System.out.print("ID : ");
		String userId = sc.nextLine();
		
		System.out.print("PWD : ");
		String userPwd = sc.nextLine();
		
		Users u = new Users();
		u.setUserId(userId);
		u.setUserPwd(userPwd);
		
		cc.login(u);
		
	}
	
	public void wantToReserve(String carName) {
		System.out.println("\n\n상담 예약 하시겠습니까?");
		System.out.print("1. 예, 에약하겠습니다.   |   2. 아뇨, 좀 더 살펴볼게요.");
		int yesOrNo = sc.nextInt();
		sc.nextLine();
		
		if(yesOrNo == 1) {
			cc.reserveCarName(carName);
		} else  {
			System.out.println("처음으로 돌아갑니다.");
			mainMenu();
		}
	}
	
	public void cancelReserve() {
		System.out.println("\n\n예약 취소 서비스입니다.");
		System.out.print("예약하셨던 성함을 입력해주세요 : ");
		String cusName = sc.nextLine();
		cc.cancelReserve(cusName);
		
	}
	
	
	public void wantToBuy(ArrayList<Car> list) {
		System.out.println("\n\n해당 차량 중 구매를 원하시는 차량이 있나요?");
		System.out.print("1. 네, 에약하겠습니다.   |   2. 네, 하지만 좀 더 살펴볼게요. | 3. 아뇨, 이 중엔 제가 원하는 차가 없습니다.");
		int yesOrNo = sc.nextInt();
		sc.nextLine();
		
		if(yesOrNo == 1) {
			String name = askCarName();
			cc.reserveCarName(name);
		} else if(yesOrNo == 2) {
			System.out.println("\n\n>>>> 조회내역 중 세부조건 조회");
			acv.qualified(list);
		} else {
			System.out.println("조건을 초기화합니다.");
			qualified();
			}
		}
	
	public void askBudjet() {
		System.out.println("\n\n차량구매 예산을 알려주세요 : ('n천만원대'로 입력)");
		String budjet = sc.nextLine();
		cc.myBudjet(budjet);
	}
	
	
	public String askCarName() {
		System.out.print("\n\n========== 차량예약 진행 ==========\n");
		System.out.print("원하시는 차량 이름을 알려주세요 : ");
		String name = sc.nextLine().toUpperCase();
		return name;
	}
	

	public void reserve(String messege) {
		System.out.print("\n\n고객님 성함 : ");
		String cusName = sc.nextLine();
		
		System.out.print("고객님 연락처 : ");
		String cusTel = sc.nextLine();
		
		System.out.print("예약할 차 이름 : ");
		String carName = sc.nextLine();
		
		Reserve r = new Reserve();
		r.setCusName(cusName);
		r.setCusTel(cusTel);
		r.setCarName(carName);
		cc.reserve(r);
	}
	

	
	//------------------------------------------------------------------------------------//
	
	public void displayFail(String messege) {
		System.out.println(messege + " 다시 시도해주세요.");
		qualified();
	}
	
	public void displayList(ArrayList<Car> list) {
		for(Car c : list) {
			System.out.println(c);
		}
		wantToBuy(list);
	}
	
	public void displayReserveList(ArrayList<Reserve> list) {
		for(Reserve r : list) {
			System.out.print(r);
		} System.out.println("\n\n상담예약 조회 완료!!");
	}
	
	public void displayStoreList(ArrayList<Stores> list) {
		for(Stores s : list) {
			System.out.print(s);
		} System.out.println("\n\n모든 상사에서 상담을 환영입니다!");
	}
	
	public void displayStore(Stores s, String name ) {
		System.out.println(name + " 차량 구매 가능한 영업소 : ");
		System.out.println(s);
	
	}
	
	public void displaySuccess(String messege) {
		System.out.println(messege + " 정보는 안전하게 보호됩니다!");
	}

}
















