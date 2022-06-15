package com.br.model.service;

import static com.br.common.JDBCTemplate.close;
import static com.br.common.JDBCTemplate.commit;
import static com.br.common.JDBCTemplate.getConnection;
import static com.br.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.br.model.dao.CarDao;
import com.br.model.vo.Car;
import com.br.model.vo.Reserve;
import com.br.model.vo.Stores;

public class CarService {
	
	
	
	//---------------- qualified() 메소드 ---------------//
	
	public ArrayList<Car> askCarType(String carType) {
		Connection conn = getConnection();
		ArrayList<Car> list = new CarDao().askCarType(conn, carType);
		close(conn);
		return list;
	}
	
	
	public ArrayList<Car> askPrice(int intPrice) {
		Connection conn = getConnection();
		ArrayList<Car> list = new CarDao().askPrice(conn, intPrice);
		close(conn);
		return list;
	}
	
	
	public ArrayList<Car> askFuel(String fuel) {
		Connection conn = getConnection();
		ArrayList<Car> list = new CarDao().askFuel(conn, fuel);
		close(conn);
		return list;
	}
	
	
	public ArrayList<Car> askNation (String nation) {
		Connection conn = getConnection();
		ArrayList<Car> list = new CarDao().askNation(conn, nation);
		close(conn);
		return list;
	}
	
	
	public ArrayList<Car> askBrand(String brand) {
		Connection conn = getConnection();
		ArrayList<Car> list = new CarDao().askBrand(conn, brand);
		close(conn);
		return list;
	}
	
	
	//----------------------------------------//
	
	public ArrayList<Stores> searchStars() {
		Connection conn = getConnection();
		ArrayList<Stores> list = new CarDao().searchStars(conn);
		close(conn);
		return list;
		
	}
	
	//---------------- 주문메소드 ---------------//
	
	
	public Stores askCarName(String carName) {
		Connection conn = getConnection();
		Stores s = new CarDao().askCarName(conn, carName);
		return s;
	}
	
	
	public int reserve(Reserve r) {
		Connection conn = getConnection();
		int result = new CarDao().reserve(conn, r);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
		
	}
}
