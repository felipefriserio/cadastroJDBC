package br.com.fiap.persistencia.interfaces;

import java.sql.SQLException;

import br.com.fiap.persistencia.model.Pessoa;

public interface CrudPessoa {
	public boolean insere(Pessoa p) throws SQLException;
	public Pessoa busca(String cpf) throws SQLException;
	public boolean deleta (String cpf) throws SQLException;
	public boolean atualiza (Pessoa p)  throws SQLException;
}
