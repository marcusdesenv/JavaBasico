package br.com.models;

public class Gato extends Animal {
	private Boolean possuiCaixaDeAreia;

	public Boolean getPossuiCaixaDeAreia() {
		return possuiCaixaDeAreia;
	}

	public void setPossuiCaixaDeAreia(Boolean possuiCaixaDeAreia) {
		this.possuiCaixaDeAreia = possuiCaixaDeAreia;
	}
	
	@Override
	public void dizerOla() {
		System.out.println("Olá eu sou um Gato!");
	}
}
