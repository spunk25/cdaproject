/**
 * 
 */
package br.com.brdigital.control.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;

import br.com.brdigital.model.entity.Beneficiado;
import br.com.brdigital.model.entity.TipoSexo;

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
	
	public void atualizar(Beneficiado ben) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dao.getConnection();
			int index = 0;
			stmt = (PreparedStatement) conn.prepareStatement("UPDATE Beneficiado SET nome = ?, apelido = ?, genero = ?, conjugue = ?,rg = ?,cpf = ?, profissao = ? WHERE cpf = "+ben.getCpf());
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
			System.err.println("SQL error: "+stmt.getPreparedSql());
			e.printStackTrace();
		} finally {
			dao.releaseAll(stmt, conn);
		}
	}
	
	public void deletar(Beneficiado ben) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dao.getConnection();
			int index = 0;
			stmt = (PreparedStatement) conn.prepareStatement("DELETE FROM Beneficiado WHERE cpf = ?");
			stmt.setString(++index, ben.getCpf());
			stmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("SQL error: "+stmt.getPreparedSql());
			e.printStackTrace();
		} finally {
			dao.releaseAll(stmt, conn);
		}
	}
	
	public Vector<Beneficiado> buscarTodos() {  
		Connection conn = null;
		PreparedStatement stmt = null;
		
		Vector<Beneficiado> resultados = new Vector<Beneficiado>();  
		ResultSet rs;  
		try {  
			conn = dao.getConnection();
			stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM Beneficiado");
			rs = stmt.executeQuery();  
			while (rs.next()) {  
				Beneficiado temp = new Beneficiado();  
				temp.setRg(rs.getString("rg"));  
				temp.setIdBeneficiado(Integer.parseInt(rs.getString("idBeneficiado")));
				temp.setNome(rs.getString("nome"));
				temp.setApelido(rs.getString("apelido"));
				temp.setGenero(TipoSexo.valueOf(rs.getString("genero")));
				temp.setConjugue(rs.getString("conjugue"));
				temp.setRg(rs.getString("rg"));
				temp.setCpf(rs.getString("cpf"));
				temp.setProfissao(rs.getString("profissao"));
				resultados.add(temp);  
			} 
		} catch (SQLException e) {  
			e.printStackTrace();  
			return null;  
		}
		return resultados;
	} 
}
