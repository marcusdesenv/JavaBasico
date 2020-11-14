import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// ctrl + shift + o
		// para realizar importação das classes

		// Faça um alteração nesse código para que o menu só saia quando
		// a opção informada for 0
		Scanner sc = new Scanner(System.in);
		int escolha;
		Opcoes opcoes = new Opcoes();
		int idade = 0;
		// Quando a idade ainda não tiver sido informada
		// e entrarem na opção 3 imprima
		// "É necessário informar a idade na opção 2" e não execute
		// o código da opção 2.

		// retorne a idade da opção 2 e atribua o valor a
		// variável idade da classe Menu
		do {
			escolha = escolherOpcao(sc);
			switch (escolha) {
			case 1:
				opcoes.selecionarOpcao1();
				break;
			case 2:
				idade = opcoes.selecionarOpcao2();
				break;
			case 3:
				opcoes.selecionarOpcao3(idade);
				break;
			default:
				Impressora.imprimaValor("Você não selecionou um opção valida!");
				break;
			}
		} while (escolha != 0);

	}

	public static int escolherOpcao(Scanner sc) {
		Impressora.imprimaValor("Escolha um número de 1 a 3 , ou 0 para sair");
		return sc.nextInt();
	}

}
