import java.util.Scanner;

public class Opcoes {

	Scanner sc = new Scanner(System.in);

	public void selecionarOpcao1() {
		// Aproveite o código nesse trecho...
		// Extract Method no eclipse para gerar método de trecho
		String animal;
		do {
			animal = lerAnimal();
			Impressora.imprimaValor("Eu prefiro gato..");
		} while (!animal.toLowerCase().equals("gato"));
		Impressora.imprimaValor("O meu também!");
	}

	public String lerAnimal() {
		Impressora.imprimaValor("Qual seu animal preferido ? ");
		return sc.nextLine();
	}

	public int selecionarOpcao2() {
		Impressora.imprimaValor("Qual a idade do seu filho");
		int idade = sc.nextInt();
		if (idade > 0 && idade < 12) {
			Impressora.imprimaValor("Ele ainda é uma criança");
		} else if (idade > 11 && idade < 19) {
			Impressora.imprimaValor("Adolescência é fogo..");
		} else {
			Impressora.imprimaValor("Ele já é um adulto!");
		}
		return idade;
	}

	public void selecionarOpcao3(int idade) {

		if (idade == 0) {
			Impressora.imprimaValor("É necessário informar a idade na opção 2");
		} else {
			for (int i = 0; i < idade; i++) {
				Impressora.imprimaValor(i + "...");
			}
			Impressora.imprimaValor(idade + " são tanto anos... ");
		}
	}

}
