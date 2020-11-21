package br.com;
import java.util.Scanner;

import br.com.models.Livro;
import br.com.util.Leitor;

/**
 * 
 */

/**
 * @author marcu
 *
 */
public class ExercicioLivros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = Leitor.lerValor("Qual  tamanho do array ?", sc, 0);
		Integer opcao = 0;
		menu(opcao, new Livro[tamanho], sc);

	}

	public static void menu(Integer opcao, Livro[] livros, Scanner sc) {
		Integer nrRegistro = 0;
		do {
			opcao = Leitor.lerValor(
					"Escolha uma opção:\n1) Listar todos os livros\n2) Cadastrar um Livro\n" + "3) Editar um livro", sc,
					opcao);
			switch (opcao) {
			case 1:
				ControleDeLivros.imprimirLivros(livros);
				break;
			case 2:
				nrRegistro = Leitor.lerValor("Qual o registro que deseja inserir:", sc, nrRegistro);
				livros[nrRegistro - 1] = ControleDeLivros.criarRegistroDeLivro(livros[nrRegistro - 1], sc);
				break;
			case 3:
				nrRegistro = Leitor.lerValor("Qual o registro que deseja editar:", sc, nrRegistro);
				livros[nrRegistro - 1] = ControleDeLivros.editarRegistroDeLivro(livros[nrRegistro - 1], sc);
				break;
			case 4:
				nrRegistro = Leitor.lerValor("Qual o registro que deseja imprimir:", sc, nrRegistro);
				ControleDeLivros.imprimirRegistro(livros[nrRegistro - 1]);
				break;
			case 5:
				nrRegistro = Leitor.lerValor("Qual o registro que deseja deletar:", sc, nrRegistro);
				livros[nrRegistro - 1] = ControleDeLivros.deletarRegistro(livros[nrRegistro - 1]);
				break;
			default:
				break;
			}
		} while (opcao != 0);
	}

}
