package com.br.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.br.common.JDBCTemplate.*;
import com.br.model.dao.CarDao;
import com.br.model.vo.Car;
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
}
