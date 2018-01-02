package br.com.fiap.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.persistencia.dao.PessoaDAO;
import br.com.fiap.persistencia.model.Pessoa;

public class Testes {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
	    System.out.println("Conexão aberta!");
	    connection.close();
	    
	    String cpf = Math.random()+"";
	    Pessoa pessoa = new Pessoa(cpf, "Mario", 40);
	    
	    // testa insert
	    System.out.println("--------- INSERT ---------");
	    System.out.println(new PessoaDAO().insere(pessoa) ? "cadastrado": "erro");
	    
	    //testa select
	    System.out.println("--------- SELECT ---------");
	    System.out.println(new PessoaDAO().busca(cpf));
	    
	    //testa update
	    System.out.println("--------- UPDATE ---------");
	    pessoa.setNome("Luigi");
	    System.out.println(new PessoaDAO().atualiza(pessoa));
	    
	    //testa delete
	    System.out.println("--------- DELETE ---------");
	    System.out.println(new PessoaDAO().deleta(cpf));
	}
}
