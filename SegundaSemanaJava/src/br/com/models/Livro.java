package br.com.models;

//  Abstração, Encapsulamento ,Herança, Polimofismo
public class Livro extends ClassePadrao {

	private Integer anoDePublicacao;
	private String autor;
	private String editora;
	private Integer classificacao;

	public Livro() {

	}

	public Livro(Integer anoDePublicacao, String nome, String autor, String editora, Integer classificacao) {
		this.anoDePublicacao = anoDePublicacao;
		this.setNome(nome);
		this.autor = autor;
		this.editora = editora;
		this.classificacao = classificacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}

	public Integer getAnoDePublicacao() {
		return anoDePublicacao;
	}

	public void setAnoDePublicacao(Integer anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
