package br.com.fiap.persistencia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.PreparedStatement;

import br.com.fiap.persistencia.ConnectionFactory;
import br.com.fiap.persistencia.interfaces.CrudPessoa;
import br.com.fiap.persistencia.model.Pessoa;

public class PessoaDAO implements CrudPessoa{
	
	public boolean insere (Pessoa p) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = (PreparedStatement) connection.prepareStatement("INSERT INTO PESSOA VALUES (?,?,?)");
			
			ps.setString(1, p.getCpf());
			ps.setInt(2, p.getIdade());
			ps.setString(3, p.getNome());
			
			int retorno = ps.executeUpdate();
			return (retorno > 0) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			ps.close();
		}
		return false;
	}
	
	public Pessoa busca(String cpf) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM PESSOA WHERE CPF = ?");
			ps.setString(1, cpf);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				return new Pessoa(
								  rs.getString("CPF"), 
								  rs.getString("NOME"), 
								  rs.getInt("IDADE")
						   );
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			rs.close();
			ps.close();
		}
		return null;
	}
	
	public boolean deleta (String cpf) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = (PreparedStatement) connection.prepareStatement("DELETE FROM PESSOA WHERE CPF = ?");
			ps.setString(1, cpf);
			
			int retorno = ps.executeUpdate();
			return (retorno > 0) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			ps.close();
		}
		return false;
	}
	
	public boolean atualiza (Pessoa p) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = (PreparedStatement) connection.prepareStatement("UPDATE PESSOA SET NOME = ?, IDADE = ? WHERE CPF = ?");
			
			ps.setString(1, p.getNome());
			ps.setInt(2, p.getIdade());
			ps.setString(3, p.getCpf());
			
			int retorno = ps.executeUpdate();
			return (retorno > 0) ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			ps.close();
		}
		return false;
	}

}
