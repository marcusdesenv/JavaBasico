package br.com.models;

public class Cachorro extends Animal {

	private Boolean possuiCama;

	public Boolean getPossuiCama() {
		return possuiCama;
	}

	public void setPossuiCama(Boolean possuiCama) {
		this.possuiCama = possuiCama;
	}
	@Override
	public void dizerOla() {
		System.out.println("Olá eu sou uma Cachorro!");
	}
}
