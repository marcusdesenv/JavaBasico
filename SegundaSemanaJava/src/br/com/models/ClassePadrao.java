package br.com.models;

public class ClassePadrao {

	protected String nome;

	public ClassePadrao() {

	}

	public ClassePadrao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return "Meu nome é : " + nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
