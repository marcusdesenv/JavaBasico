package br.com.afrodev.hibernate.models;

public enum Sexo {
	MASCULINO("Masculino", "M"), FEMININO("Feminino", "F");

	Sexo(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	private String nome;
	private String sigla;

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}
}
