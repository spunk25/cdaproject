/**
 * 
 */
package br.com.brdigital.control.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import br.com.brdigital.model.entity.Beneficiado;
import br.com.brdigital.model.entity.Contato;
import br.com.brdigital.model.entity.Endereco;
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
	
	public long inserir(Beneficiado ben) {
		Connection conn = null;
		PreparedStatement stmt = null;
		long idCriado;
		
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
			idCriado = stmt.getLastInsertID();
		}
		return idCriado;
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
			stmt = (PreparedStatement) conn.prepareStatement("DELETE FROM Beneficiado WHERE idBeneficiado = ? OR cpf = ?");
			stmt.setLong(++index, ben.getIdBeneficiado());
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
	
	public Beneficiado buscarUm(int ID) {  
		Connection conn = null;
		PreparedStatement stmt = null;
		
		Beneficiado temp = new Beneficiado();  
		ResultSet rs;  
		try {  
			conn = dao.getConnection();
			stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM Beneficiado WHERE idBeneficiado = ?");
			int index = 0;
			stmt.setInt(++index, ID);
			rs = stmt.executeQuery();  
			while (rs.next()) {  
				temp.setIdBeneficiado(rs.getInt("idBeneficiado"));
				temp.setNome(rs.getString("nome"));
				temp.setApelido(rs.getString("apelido"));
				temp.setGenero(TipoSexo.valueOf(rs.getString("genero")));
				temp.setConjugue(rs.getString("conjugue"));
				temp.setRg(rs.getString("rg"));
				temp.setCpf(rs.getString("cpf"));
				temp.setProfissao(rs.getString("profissao"));
				
				PreparedStatement stmtende = (PreparedStatement) conn.prepareStatement("SELECT * FROM Endereco WHERE Beneficiado_idBeneficiado = ?");
				stmtende.setLong(1, temp.getIdBeneficiado());
				ResultSet rsende = stmtende.executeQuery();
				while(rsende.next()) {
					Endereco endereco = new Endereco(rsende.getString("endereco"),rsende.getInt("numero"),rsende.getString("bairro"));
					temp.setEndereco(endereco);
				}
				
				PreparedStatement stmtcontato = (PreparedStatement) conn.prepareStatement("SELECT * FROM Contato WHERE Beneficiado_idBeneficiado = ?");
				stmtcontato.setLong(1, temp.getIdBeneficiado());
				ResultSet rscontato = stmtcontato.executeQuery();
				while(rscontato.next()) {
					Contato conta = new Contato(rscontato.getString("telefone"), rscontato.getString("celular"), rscontato.getString("email"));
					temp.setContato(conta);
				  
				}	
			} 
		} catch (SQLException e) {  
			e.printStackTrace();  
			return null;  
		}
		return temp;
	}
	
	public List<Beneficiado> buscarTodos() {  
		Connection conn = null;
		PreparedStatement stmt = null;
		
		List<Beneficiado> resultados = new ArrayList<Beneficiado>();  
		ResultSet rs;  
		try {  
			conn = dao.getConnection();
			stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM Beneficiado");
			rs = stmt.executeQuery();  
			while (rs.next()) {  
				Beneficiado temp = new Beneficiado();  
				temp.setIdBeneficiado(rs.getInt("idBeneficiado"));
				temp.setNome(rs.getString("nome"));
				temp.setApelido(rs.getString("apelido"));
				temp.setGenero(TipoSexo.valueOf(rs.getString("genero")));
				temp.setConjugue(rs.getString("conjugue"));
				temp.setRg(rs.getString("rg"));
				temp.setCpf(rs.getString("cpf"));
				temp.setProfissao(rs.getString("profissao"));
				
				PreparedStatement stmtende = (PreparedStatement) conn.prepareStatement("SELECT * FROM Endereco WHERE Beneficiado_idBeneficiado = ?");
				stmtende.setLong(1, temp.getIdBeneficiado());
				ResultSet rsende = stmtende.executeQuery();
				while(rsende.next()) {
					Endereco endereco = new Endereco(rsende.getString("endereco"),rsende.getInt("numero"),rsende.getString("bairro"));
					temp.setEndereco(endereco);
				}
				
				PreparedStatement stmtcontato = (PreparedStatement) conn.prepareStatement("SELECT * FROM Contato WHERE Beneficiado_idBeneficiado = ?");
				stmtcontato.setLong(1, temp.getIdBeneficiado());
				ResultSet rscontato = stmtcontato.executeQuery();
				while(rscontato.next()) {
					Contato conta = new Contato(rscontato.getString("telefone"), rscontato.getString("celular"), rscontato.getString("email"));
					temp.setContato(conta);
				}
				
				resultados.add(temp);  
			} 
		} catch (SQLException e) {  
			e.printStackTrace();  
			return null;  
		}
		return resultados;
	} 
}
