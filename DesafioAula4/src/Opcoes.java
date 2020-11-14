import java.util.Scanner;

public class Opcoes {

	Scanner sc = new Scanner(System.in);

	public void selecionarOpcao1() {
		// Aproveite o c�digo nesse trecho...
		// Extract Method no eclipse para gerar m�todo de trecho
		String animal;
		do {
			animal = lerAnimal();
			Impressora.imprimaValor("Eu prefiro gato..");
		} while (!animal.toLowerCase().equals("gato"));
		Impressora.imprimaValor("O meu tamb�m!");
	}

	public String lerAnimal() {
		Impressora.imprimaValor("Qual seu animal preferido ? ");
		return sc.nextLine();
	}

	public int selecionarOpcao2() {
		Impressora.imprimaValor("Qual a idade do seu filho");
		int idade = sc.nextInt();
		if (idade > 0 && idade < 12) {
			Impressora.imprimaValor("Ele ainda � uma crian�a");
		} else if (idade > 11 && idade < 19) {
			Impressora.imprimaValor("Adolesc�ncia � fogo..");
		} else {
			Impressora.imprimaValor("Ele j� � um adulto!");
		}
		return idade;
	}

	public void selecionarOpcao3(int idade) {

		if (idade == 0) {
			Impressora.imprimaValor("� necess�rio informar a idade na op��o 2");
		} else {
			for (int i = 0; i < idade; i++) {
				Impressora.imprimaValor(i + "...");
			}
			Impressora.imprimaValor(idade + " s�o tanto anos... ");
		}
	}

}
