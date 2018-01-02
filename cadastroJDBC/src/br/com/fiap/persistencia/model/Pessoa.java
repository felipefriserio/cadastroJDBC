package br.com.fiap.persistencia.model;

public class Pessoa {
	
	public Pessoa() {}
	public Pessoa(String cpf, String nome, int idade) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
	}
	
	private String cpf;
	private String nome;
	private int idade;
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + "]";
	}
}
