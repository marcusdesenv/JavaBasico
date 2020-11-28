package br.com.afrodev.hibernate.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "tb_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idt_pessoa")
	private Long idt;

	@Column(name = "nme_pessoa", length = 200, nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(name = "sexo_pessoa", nullable = false)
	private Sexo sexo;

	@Column(name = "ida_pessoa")
	private Integer idade;

	@OneToMany
	private List<Personalidade> personalidades = new ArrayList<>();

	public Pessoa() {
	}

	public Pessoa(Long idt, String nome, Sexo sexo, Integer idade, List<Personalidade> personalidades) {

		this.idt = idt;
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.personalidades = personalidades;
	}

	public List<Personalidade> getPersonalidades() {
		return personalidades;
	}

	public void setPersonalidades(List<Personalidade> personalidades) {
		this.personalidades = personalidades;
	}

	public Long getIdt() {
		return idt;
	}

	public void setIdt(Long idt) {
		this.idt = idt;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {

		return "Sexo: ".concat(sexo == null ? "" : sexo.getNome()).concat("\n Nome: ")
				.concat(nome == null ? "" : nome.toString());
	}
}
