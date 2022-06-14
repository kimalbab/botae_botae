package com.br.model.dao;

import static com.br.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.br.model.vo.Car;
import com.br.model.vo.Stores;

public class CarDao {
	
	private Properties prop = new Properties();
	
	public CarDao() {
		try {
			prop.loadFromXML(new FileInputStream("src/resources/query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Car> askCarType(Connection conn, String carType) {
		ArrayList<Car> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("askCarType");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carType);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Car(rset.getString("CAR_NAME"),
								 rset.getString("CAR_TYPE"),
								 rset.getString("PRICE"),
								 rset.getString("FUEL"),
								 rset.getString("NATION"),
								 rset.getString("BRAND")
								 //rset.getString("STORE_ID")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public Stores askCarName(Connection conn, String name) {
		Stores s = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("askCarName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				s = new Stores(rset.getString("STORE_NAME"),
							rset.getString("STORE_TELL"),
							rset.getInt("STARS"),
							rset.getString("ADDRESS")
						);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return s;
	}
	

}


















