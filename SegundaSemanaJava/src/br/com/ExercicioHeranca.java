package br.com;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.models.Animal;
import br.com.models.Cachorro;
import br.com.models.Galinha;
import br.com.models.Gato;

public class ExercicioHeranca {

	public static void main(String[] args) {
		//
		// Animal ab = new Animal();
		// for (Animal a : arrayListAnimais) {
		// arrayListAnimais.remove(0);
		// ab = a;
		// }
		// arrayListAnimais.forEach(data -> {
		// data.setIdade(10);
		// data.dizerOla();
		// });
		// ArrayList<Animal> animaisParaDeletar = new ArrayList<Animal>();
		// for (int i = 0; i < arrayListAnimais.size(); i++) {
		//
		// if (arrayListAnimais.get(i) instanceof Gato) {
		// animaisParaDeletar.add(arrayListAnimais.get(i));
		// }
		// System.out.println(arrayListAnimais.get(i).getNome());
		// }
		// arrayListAnimais.removeAll(animaisParaDeletar);

		// System.out.print("Teste".toUpperCase().contains("T"));
		ArrayList<Animal> arrayListAnimais = new ArrayList<>();

		menu(arrayListAnimais);

	}

	// Faça um programa para ler animais e ao fechar imprimir quantos são
	// Cachorros, Gatos e Galinhas;
	public static void menu(ArrayList<Animal> arrayListAnimais) {
		Scanner sc = new Scanner(System.in);
		Integer opcao = 0;
		Integer quantidadeGatos = 0;
		Integer quantidadeCachorros = 0;
		Integer quantidadeGalinhas = 0;
		do {
			System.out.print("--------------------------------\n");
			opcao = Leitor.lerValor("0) Sair\n1) Cadastrar Animal\n2)Listar Animais\n ", sc, opcao);
			switch (opcao.intValue()) {
			case 0:
				System.out.println("Saindo..");
				for (Animal a : arrayListAnimais) {
					if (a instanceof Gato) {
						quantidadeGatos++;
					} else if (a instanceof Cachorro) {
						quantidadeCachorros++;
					} else if (a instanceof Galinha) {
						quantidadeGalinhas++;
					}
				}
				System.out.print("--------------------------------\n");
				System.out.printf("Quantidade de Gatos foi: %d \n", quantidadeGatos);
				System.out.printf("Quantidade de Cachorros foi: %d \n", quantidadeCachorros);
				System.out.printf("Quantidade de Galinhas foi: %d \n", quantidadeGalinhas);

				break;
			case 1:
				arrayListAnimais.addAll(cadastrarAnimal(sc));
				break;
			case 2:
				// Não precisa implementar agora
				break;
			default:
				break;
			}

		} while (opcao != 0);
	}

	private static ArrayList<Animal> cadastrarAnimal(Scanner sc) {
		ArrayList<Animal> animaisParaCadastro = new ArrayList<>();
		Integer opcao = 0;
		do {
			System.out.print("--------------------------------\n");
			opcao = Leitor.lerValor("0) Sair\n1) Cadastrar Gato\n2) Cadastrar Cachorro\n"
			+ "3) Cadastrar Galinha", sc,
					0);
			switch (opcao.intValue()) {
			case 0:

				break;
			case 1:
				animaisParaCadastro.add(cadastrarGato(sc));
				break;
			case 2:
				animaisParaCadastro.add(cadastrarCachorro(sc));
				break;
			case 3:
				animaisParaCadastro.add(cadastrarGalinha(sc));
				break;
			default:
				break;
			}

		} while (opcao != 0);

		return animaisParaCadastro;
	}

	private static Animal cadastrarGalinha(Scanner sc) {
		// TODO Auto-generated method stub
		return new Galinha();
	}

	private static Animal cadastrarCachorro(Scanner sc) {
		// TODO Auto-generated method stub
		return new Cachorro();
	}

	private static Animal cadastrarGato(Scanner sc) {
		// TODO Auto-generated method stub
		return new Gato();
	}
}
