
public class Pessoa {

	private String nome;
	private Float peso;
	private Character sexo;

	// Método Construtor Executa ao Criar uma instância da Classe
	public Pessoa() {

	}

	public Pessoa(String nome, Float peso, Character sexo) {
		this.nome = nome;
		this.peso = peso;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
