import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// ctrl + shift + o
		// para realizar importa��o das classes

		// Fa�a um altera��o nesse c�digo para que o menu s� saia quando
		// a op��o informada for 0
		Scanner sc = new Scanner(System.in);
		int escolha;
		Opcoes opcoes = new Opcoes();
		int idade = 0;
		// Quando a idade ainda n�o tiver sido informada
		// e entrarem na op��o 3 imprima
		// "� necess�rio informar a idade na op��o 2" e n�o execute
		// o c�digo da op��o 2.

		// retorne a idade da op��o 2 e atribua o valor a
		// vari�vel idade da classe Menu
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
				Impressora.imprimaValor("Voc� n�o selecionou um op��o valida!");
				break;
			}
		} while (escolha != 0);

	}

	public static int escolherOpcao(Scanner sc) {
		Impressora.imprimaValor("Escolha um n�mero de 1 a 3 , ou 0 para sair");
		return sc.nextInt();
	}

}
