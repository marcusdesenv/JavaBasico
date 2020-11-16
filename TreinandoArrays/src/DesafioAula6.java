import java.util.Scanner;

/**
 * 
 */

/**
 * @author marcu
 *
 */
public class DesafioAula6 {

	public static String lerValor(String pergunta, Scanner sc) {
		System.out.println(pergunta);
		return sc.next();
	}

	public static float lerValor(String pergunta, Scanner sc, float valor) {
		System.out.println(pergunta);
		return sc.nextFloat();
	}

	public static int lerValor(String pergunta, Scanner sc, int valor) {
		System.out.println(pergunta);
		return sc.nextInt();
	}

	public static char lerValor(String pergunta, Scanner sc, char valor) {
		System.out.println(pergunta);
		String retorno = sc.next();
		return retorno.charAt(0);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Crie 3 arrays com 6 posicoes
		// primeiro array com nomes (String)
		// segundo array com peso (float)
		// terceiro array com sexo (char) // F,M
		// Definir o tamanho dos array com base em uma entrada
		// Crie um menu usando o switch com as opções do tipo (1 a 3):
		// apresentarTodosOsValoresDoArray,
		// alterarTodoOArray, alterarArrayPorPosicao
		// utilize o while para parar o programa somente quando informar o valor 0
		Scanner sc = new Scanner(System.in);
		int tamanho = lerValor("Qual o tamanho do array ?", sc, 0);

		String[] nomes = new String[tamanho];
		float[] pesos = new float[tamanho];
		char[] sexos = new char[tamanho];
		int opcao = 0;
		int nrRegistro = 0;
		String sexo;
		do {
			opcao = lerValor("Informe a opção que deseja acessar:", sc, opcao);
			switch (opcao) {
			case 0:
				System.out.println("Saindo..");
				break;
			case 1:
				for (int i = 0; i < tamanho; i++) {
					System.out.printf("Nome: %s \nPeso: %.2f\nSexo: %s\n", nomes[i], pesos[i], sexos[i]);
				}
				break;
			case 2:
				for (int i = 0; i < tamanho; i++) {
					System.out.printf("Registro nr %d \n", (i + 1));
					adicionarValorArray(nomes, pesos, sexos, i, sc);
					System.out.println("-----------------------");
				}
				break;
			case 3:
				nrRegistro = lerValor("Informe o nº do registro para alteração:", sc, nrRegistro);
				adicionarValorArray(nomes, pesos, sexos, (nrRegistro - 1), sc);
				break;
			case 4:
				// Crie a opção 4 tenha uma seleção de qual informação o usuário deseja alterar.
				nrRegistro = lerValor("Informe o nº do registro para alteração:", sc, nrRegistro);
				int campoAlterando = lerValor("Qual a opção que deseja alterar ? \n1-Nome;\n2-Peso;\n3-Sexo;", sc, 0);
				adicionarValorArray(nomes, pesos, sexos, (nrRegistro - 1), sc, campoAlterando);
				break;
			case 5:
				// Imprimir valores por registro
				nrRegistro = lerValor("Informe o nº do registro para alteração:", sc, 0);
				System.out.printf("Nome: %s \nPeso: %.2f\nSexo: %s\n", nomes[nrRegistro - 1], pesos[nrRegistro - 1],
						sexos[nrRegistro - 1]);
				break;
			default:
				System.out.println("Opção invalida!");
				break;
			}
		} while (opcao != 0);

	}

	private static void adicionarValorArray(String[] nomes, float[] pesos, char[] sexos, int i, Scanner sc) {
		nomes[i] = lerValor("Informe o nome: ", sc);
		pesos[i] = lerValor("Informe o peso: ", sc, pesos[i]);
		sexos[i] = lerValor("Informe o sexo (F/M): ", sc, sexos[i]);
	}

	private static void adicionarValorArray(String[] nomes, float[] pesos, char[] sexos, int i, Scanner sc,
			int campoAlterando) {
		if (campoAlterando == 1) {
			nomes[i] = lerValor("Informe o nome: ", sc);
		} else if (campoAlterando == 2) {
			pesos[i] = lerValor("Informe o peso: ", sc, pesos[i]);
		} else if (campoAlterando == 3) {
			sexos[i] = lerValor("Informe o sexo (F/M): ", sc, sexos[i]);
		}
	}
	// Criem mais uma sobrecarga do método adicionarValorArray para o opção 4

}
