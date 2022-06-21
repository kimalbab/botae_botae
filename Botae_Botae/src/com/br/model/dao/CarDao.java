package com.br.model.dao;

import static com.br.common.JDBCTemplate.close;
import static com.br.common.JDBCTemplate.commit;
import static com.br.common.JDBCTemplate.rollback;

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
import com.br.model.vo.Reserve;
import com.br.model.vo.Stores;
import com.br.model.vo.Users;

public class CarDao {
	
	private Properties prop = new Properties();
	
	public CarDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//---------------- qualified() 메소드 ---------------//
	
	
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
	
	public ArrayList<Car> askPrice(Connection conn, int intPrice) {
		
		ArrayList<Car> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("askPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + intPrice + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Car(rset.getString("CAR_NAME"),
								 rset.getString("CAR_TYPE"),
								 rset.getString("PRICE"),
								 rset.getString("FUEL"),
								 rset.getString("NATION"),
								 rset.getString("BRAND")
						));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}
	
	
	public ArrayList<Car> askFuel(Connection conn, String fuel) {
		
		ArrayList<Car> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("askFuel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + fuel + "%");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Car(rset.getString("CAR_NAME"),
								 rset.getString("CAR_TYPE"),
								 rset.getString("PRICE"),
								 rset.getString("FUEL"),
								 rset.getString("NATION"),
								 rset.getString("BRAND")
						));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}
	
	public ArrayList<Car> askNation(Connection conn, String nation) {
		ArrayList<Car> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("askNation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nation);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Car(rset.getString("CAR_NAME"),
								 rset.getString("CAR_TYPE"),
								 rset.getString("PRICE"),
								 rset.getString("FUEL"),
								 rset.getString("NATION"),
								 rset.getString("BRAND")
						));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}
	
	public ArrayList<Car> askBrand(Connection conn, String brand) {
		
		ArrayList<Car> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("askBrand");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brand);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Car(rset.getString("CAR_NAME"),
								 rset.getString("CAR_TYPE"),
								 rset.getString("PRICE"),
								 rset.getString("FUEL"),
								 rset.getString("NATION"),
								 rset.getString("BRAND")
						));	}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		} return list;

	}

	//----------------------------------------//
	
	public ArrayList<Stores> searchStars(Connection conn) {
		
		ArrayList<Stores> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchStars");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Stores(rset.getString("STORE_NAME"),
									rset.getString("STORE_TEL"),
									rset.getInt("STARS"),
									rset.getString("ADDRESS")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}
	
	
public ArrayList<Car> orderBy(Connection conn) {
		
		ArrayList<Car> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("onlySelect");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Car(rset.getString("CAR_NAME"),
								 rset.getString("CAR_TYPE"),
								 rset.getString("PRICE"),
								 rset.getString("FUEL"),
								 rset.getString("NATION"),
								 rset.getString("BRAND")
						));	}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		} return list;

	}
	
public int insertByPrice(Connection conn, ArrayList<Car> alterList){
	
	//ArrayList<Car> newList = new ArrayList<>();
	PreparedStatement pstmt = null;
	int result = 0;
	
	String sql = prop.getProperty("insertByPrice");
	
	try {
		
		for(int i =0; i< alterList.size(); i++) {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, alterList.get(i).getCarName());
			pstmt.setString(2, alterList.get(i).getCarType());
			pstmt.setInt(3, alterList.get(i).getIntPrice());
			pstmt.setString(4, alterList.get(i).getFuel());
			pstmt.setString(5, alterList.get(i).getNation());
		    pstmt.setString(6, alterList.get(i).getBrand());
		   
		}
	    result = pstmt.executeUpdate();	
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	return result;
}
	
	public ArrayList<Car> orderByPrice(Connection conn){
		
		ArrayList<Car> newList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("orderByPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				newList.add(new Car(rset.getString("CAR_NAME"),
								 rset.getString("CAR_TYPE"),
								 rset.getInt("INT_PRICE"),
								 rset.getString("FUEL"),
								 rset.getString("NATION"),
								 rset.getString("BRAND")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return newList;
	}
	
	
	public ArrayList<Car> myBudjet(Connection conn) {
		
		ArrayList<Car> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("onlySelect");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Car(rset.getString("CAR_NAME"),
								 rset.getString("CAR_TYPE"),
								 rset.getString("PRICE"),
								 rset.getString("FUEL"),
								 rset.getString("NATION"),
								 rset.getString("BRAND")
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
	
	
	
	//---------------- 주문메소드 ---------------//
	
	
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
							rset.getString("STORE_TEL"),
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
	
	public int reserve(Connection conn, Reserve r) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("reserve");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getCusName());
			pstmt.setString(2, r.getCusTel());
			pstmt.setString(3, r.getCarName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	public int cancleReserve(Connection conn, String cusName) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("cancleReserve");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cusName);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	public Users login(Connection conn, Users u) {
		
		Users newU = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("login");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserPwd());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {

						
			newU = new Users(rset.getInt("USER_NO"),
							 rset.getString("USER_NAME"),
							 rset.getString("USER_PWD")
							
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return newU;
	}
	
	public ArrayList<Reserve> viewReserve(Connection conn) {
		
		ArrayList<Reserve> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("viewReserve");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Reserve(rset.getString("CUS_NAME"),
									 rset.getString("CUS_TEL"),
									 rset.getString("CAR_NAME")
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
}


















