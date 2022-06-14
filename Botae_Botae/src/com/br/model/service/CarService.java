package com.br.model.service;

import static com.br.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.br.model.dao.CarDao;
import com.br.model.vo.Car;
import com.br.model.vo.Reserve;
import com.br.model.vo.Stores;

public class CarService {
	
	public ArrayList<Car> askCarType(String carType) {
		Connection conn = getConnection();
		ArrayList<Car> list = new CarDao().askCarType(conn, carType);
		close(conn);
		return list;
	}
	
	
	public Stores askCarName(String name) {
		Connection conn = getConnection();
		Stores s = new CarDao().askCarName(conn, name);
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
