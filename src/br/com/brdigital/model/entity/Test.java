package br.com.brdigital.model.entity;

import java.sql.SQLException;

import br.com.brdigital.control.dao.GenericaDao;

public class Test {
	public static void main(String arg[]) {
		GenericaDao dao = new GenericaDao();
		try {
			dao.getConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
