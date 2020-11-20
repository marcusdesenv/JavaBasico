package br.com.models;

public class Pessoa extends ClassePadrao {

	private Float peso;
	private Character sexo;

	// Método Construtor Executa ao Criar uma instância da Classe
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, Float peso, Character sexo) {
		super();
		this.setNome(nome);
		this.peso = peso;
		this.sexo = sexo;
	}

	@Override
	public String getNome() {
		return "Pessoa: " + this.nome;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
}
