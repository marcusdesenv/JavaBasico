package br.com;

import br.com.models.ClassePadrao;

public class Pessoa extends ClassePadrao {

	private Float peso;
	private Character sexo;

	// M�todo Construtor Executa ao Criar uma inst�ncia da Classe
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
