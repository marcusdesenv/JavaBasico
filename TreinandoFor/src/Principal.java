import java.util.Scanner;

/**
 * 
 */

/**
 * @author marcu
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Verifique se uma string tem o tamanho maior que 10 usando o for
		// Imprima caracter a caracter da string
		// Quando a string tiver a letra "a" pule 2 caracteres se possível
		Scanner sc = new Scanner(System.in);
		String texto = sc.nextLine();
		// for (int i = 0; i < texto.length(); i++) {
		// if (i == 8) {
		// System.out.print("O tamanho da String é maior que 10");
		// }
		//		// System.out.println(texto.substring(i, (i + 1)));
		// if (texto.substring(i, (i + 1)).toLowerCase().equals("a")
		// && (i + 2) < texto.length()) {
		// i = i + 2;
		// }// }
		String textob = "Marcus, Fabiano, Icaro, Renata";
		String[] nomes = textob.split(",");
		 textob.split("");
		for (String i : nomes) {
			System.out.println(i);
		}

		for (int i = 0; i < texto.length(); i++) {
			
			System.out.println(texto.substring(i, (i + 1)));
			if (texto.substring(i, (i + 1)).toLowerCase().equals("a") && (i + 2) < texto.length()) {
				i = i + 2;
			}
		}
		int controleAchouA = 0;
		// contains... verifica se a String contem o caracter informado. 
		// break - para o for
		// continue - ele volta para o inicio do for
		for(String a: texto.split("") ) {
			if(controleAchouA == 0) {
				System.out.println(a);
			}else {
				controleAchouA--;
			}
			if(a.toLowerCase().contains("a")) {
				controleAchouA = 2;
			}
		}
		for(String a : texto.split("") ) {
			if(a.toLowerCase().contains("b")) {
				System.out.print("Encontrei um b");
				continue;
			}
			System.out.println("Não encontrei um b");
		}
		for(String a: texto.split("") ) {
			if(a.toLowerCase().contains("b")) {
				System.out.print("Encontrei um b");
				break;
			}
			System.out.println("Não encontrei um b");
		}
				
		
	}

}
