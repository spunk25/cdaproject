package br.com.brdigital.control.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class GenericaDao {
	
	private final String strDriver = "com.mysql.jdbc.Driver";
	private String strConnection = "";
	
	public GenericaDao() {
		super();
		this.setStrConnection("localhost", "3306", "dbcda");
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(strDriver);
			conn = DriverManager.getConnection(getStrConnection(),"root", "bras8906");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return conn;
	}
	
	private void release(Statement stmt) {
		try {
			if (!stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void release(Connection conn) {
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void release(ResultSet rset) {
		try {
			if (!rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void releaseAll(Statement stmt, Connection conn) {
		release(stmt);
		release(conn);
	}
	
	public void releaseAll(Statement stmt, Connection conn, ResultSet rset) {
		release(rset);
		releaseAll(stmt,conn);
	}
	
	public String getStrConnection() {
		return strConnection;
	}
	
	public void setStrConnection(String server,String port,String database) {
		this.strConnection = "jdbc:mysql://"+server+":"+port+"/"+database;
	}
}
