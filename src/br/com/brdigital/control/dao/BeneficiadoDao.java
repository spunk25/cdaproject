/**
 * 
 */
package br.com.brdigital.control.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.com.brdigital.model.entity.Beneficiado;

/**
 * @author bramon
 *
 */
public class BeneficiadoDao {
	
	private GenericaDao dao;

	/**
	 * 
	 */
	public BeneficiadoDao() {
		dao = new GenericaDao();		
	}
	
	public void inserir(Beneficiado ben) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dao.getConnection();
			int index = 0;
			stmt = (PreparedStatement) conn.prepareStatement("INSERT INTO Beneficiado (nome,apelido,genero,conjugue,rg,cpf,profissao) VALUES (?,?,?,?,?,?,?)");
			stmt.setString(++index, ben.getNome());
			stmt.setString(++index, ben.getApelido());
			stmt.setString(++index, ben.getGenero().getSexo());
			stmt.setString(++index, ben.getConjugue());
			stmt.setString(++index, ben.getRg());
			stmt.setString(++index, ben.getCpf());
			stmt.setString(++index, ben.getProfissao());
			stmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dao.releaseAll(stmt, conn);
		}
	}
	
	
}
