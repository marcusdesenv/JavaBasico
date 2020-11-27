package br.com.terceira;

import java.util.List;
import java.util.Scanner;

import br.com.terceiro.dao.UsuarioDAO;
import br.com.terceiro.models.Usuario;
import br.com.terceiro.util.Leitor;

public class Principal {

	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();
		Scanner sc = new Scanner(System.in);
		Integer menu = 0;
		if (login(sc, dao) == 1) {
			do {
				menu = Leitor.lerValor("1) Buscar Todos\n2) Cadastrar\n3) Editar\n4) Deletar\n", sc, menu);
				switch (menu.intValue()) {
				case 1:
					buscarUsuarios(dao);
					break;
				case 2:
					cadastrarUsuario(dao, sc);
					break;
				case 3:
					editarUsuario(dao, sc);
					break;
				case 4:
					deletarUsuario(dao, sc);
					break;
				default:
					System.out.println("Opção Inválida");
					break;
				}

			} while (menu != 0);

		}
		System.out.println("Saindo...");

	}

	private static void deletarUsuario(UsuarioDAO dao, Scanner sc) {
		Usuario usuarioSelecionado = buscarUsuarioPorParteDoNome(dao, sc,
				"Qual o identificador do usuário que deseja deletar ? ");
		if (usuarioSelecionado != null) {
			if (dao.deletarUsuario(usuarioSelecionado.getIdt()) > 0) {
				System.out.printf("Usuário %s deletado com sucesso!", usuarioSelecionado.getNmeUsuario());
			} else {
				System.out.printf("Não foi possivel deletar o usuário %s ", usuarioSelecionado.getNmeUsuario());
			}
		} else {
			System.out.printf("Nenhum usuario para deletar !");
		}
	}

	/**
	 * @param dao
	 * @param sc
	 */
	private static void editarUsuario(UsuarioDAO dao, Scanner sc) {
		Usuario usuarioSelecionado = buscarUsuarioPorParteDoNome(dao, sc,
				"Qual o identificador do usuário que deseja editar ? ");

		imprimirValorUsuario(usuarioSelecionado);
		String novoNomeDeUsuario = Leitor.lerValor("\nQual o novo valor de nome ? ", sc);
		usuarioSelecionado.setNmeUsuario(
				novoNomeDeUsuario == null || novoNomeDeUsuario.equals("") ? usuarioSelecionado.getNmeUsuario()
						: novoNomeDeUsuario);
		String novoLoginDoUsuario = Leitor.lerValor("\nQual o login que deseja utilizar ? ", sc);
		usuarioSelecionado.setUsrUsuario(
				novoLoginDoUsuario == null || novoLoginDoUsuario.equals("") ? usuarioSelecionado.getUsrUsuario()
						: novoLoginDoUsuario);

		dao.editarUsuario(usuarioSelecionado);
	}

	public static Usuario buscarUsuarioPorParteDoNome(UsuarioDAO dao, Scanner sc, String perguntaSelecao) {

		List<Usuario> usuarios = dao
				.buscarUsuariosPorParteDoNome(Leitor.lerValor("Qual o nome do usuário que está buscando ?", sc));
		if (usuarios.size() == 1) {
			imprimirValorUsuario(usuarios.get(0));
			if (Leitor.lerValor("É esse usuário que você procura ? ", sc, false)) {
				return usuarios.get(0);
			}

		} else if (usuarios.size() == 0) {
			System.out.println("Nenhum usuário encontrado");

		} else {
			usuarios.forEach(usuario -> {
				imprimirValorUsuario(usuario);
			});
			Long identificadoUsuarioSelecionado = Leitor.lerValor(perguntaSelecao, sc, 0L);
			return buscarNaListaUsuarioPorIdentificador(usuarios, identificadoUsuarioSelecionado);
		}
		return null;
	}

	private static Usuario buscarNaListaUsuarioPorIdentificador(List<Usuario> usuarios,
			Long identificadoUsuarioSelecionado) {
		Usuario u = null;
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getIdt().equals(identificadoUsuarioSelecionado)) {
				u = usuarios.get(i);
			}
		}
		return u;
	}

	public static void imprimirValorUsuario(Usuario usuario) {
		System.out.printf("Identificador: %d\nNome: %s\nUsuario: %s\n", usuario.getIdt(), usuario.getNmeUsuario(),
				usuario.getUsrUsuario());
	}

	private static void cadastrarUsuario(UsuarioDAO dao, Scanner sc) {
		Usuario u = new Usuario();

		try {
			u.setNmeUsuario(Leitor.lerValor("Qual o Nome do usuário :", sc));
			u.setUsrUsuario(Leitor.lerValor("Qual o login que deseja utilizar :", sc));
			String senha = Leitor.lerValor("Qual a senha:", sc);
			if (dao.cadastrarUsuario(u, senha) > 0) {
				System.out.println("Usuário Cadastrado com sucesso!");
			} else {
				System.out.println("Usuário não foi cadastrado...");
			}
		} catch (Exception e) {
			System.out.println("Um erro ocorreu ao tentar cadastrar o usuário");
		}

	}

	public static void buscarUsuarios(UsuarioDAO dao) {
		List<Usuario> usuarios = dao.buscarUsuarios();
		usuarios.forEach(usuario -> {
			imprimirValorUsuario(usuario);
			System.out.printf("--------------\n");
		});

	}

	/**
	 * 
	 * Crie um método login: Retorna true (Caso usuário e senha esteja correto) e
	 * false(Quando usuário e senha estiver errado) Informe "Login realizado com
	 * sucesso!" caso true ou "Seu Usuário ou senha Estão incorretos", informe
	 * novamente. (crie um loop com a opção para sair)
	 */
	private static Integer login(Scanner sc, UsuarioDAO dao) {
		Integer testeLogin = 0;
		Boolean tentarNovamente = false;
		do {
			tentarNovamente = false;
			String usuario = Leitor.lerValor("Usuario:", sc);
			String senha = Leitor.lerValor("Senha:", sc);
			if (dao.verificarUsuarioESenha(usuario, senha)) {
				System.out.println("Login realizado com sucesso!");
				testeLogin = 1;
			} else {
				System.out.println("Seu usuário ou senha estão incorretos");
				tentarNovamente = Leitor.lerValor("Gostaria de tentar novamente - Sim/Nao :", sc, tentarNovamente);
			}

		} while (testeLogin == 0 || tentarNovamente);
		return testeLogin;
	}
}
