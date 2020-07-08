package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.LoginBean;
import com.bean.RegisterBean;

public class Dao {
	private Connection conn;
	private PreparedStatement stmt;
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
	
	public Dao() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public boolean userExists(LoginBean lb) {
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select * from userdata where name=? and password=?");
			stmt.setString(1, lb.getUname());
			stmt.setString(2, lb.getPwd());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean registerUser(RegisterBean rb) {
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select * from userdata where name=?");
			stmt.setString(1, rb.getUname());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return false;
			} else {
				stmt = conn.prepareStatement("insert into userdata(name,password,email,city) values(?,?,?,?)");
				stmt.setString(1, rb.getUname());
				stmt.setString(2, rb.getPwd());
				stmt.setString(3, rb.getEmail());
				stmt.setString(4, rb.getAddress());
				
				int success = stmt.executeUpdate();
				if(success != 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean editUser(RegisterBean rb) {
		try {
			stmt = conn.prepareStatement("update userdata set password=?,email=?,city=? where name=?");
			stmt.setString(1, rb.getPwd());
			stmt.setString(2, rb.getEmail());
			stmt.setString(3, rb.getAddress());
			stmt.setString(4, rb.getUname());
			int success = stmt.executeUpdate();
			
			if(success != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void deleteUser(String name) {
		try {
			stmt = conn.prepareStatement("delete from userdata where name=?");
			stmt.setString(1, name);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<RegisterBean> getAllRecords() {
		List<RegisterBean> rbList = new ArrayList<RegisterBean>();
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select * from userdata");
			rs = stmt.executeQuery();
			while(rs.next()) {
				rbList.add(new RegisterBean(rs.getString("name"), // uname
						rs.getString("password"), // password
						rs.getString("email"), // email
						rs.getString("city")) // address
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rbList;
	}
	
	public RegisterBean getUserByName(String name) {
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("select * from userdata where name=?");
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new RegisterBean(rs.getString("name"),
									rs.getString("password"),
									rs.getString("email"),
									rs.getString("city")
						);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
