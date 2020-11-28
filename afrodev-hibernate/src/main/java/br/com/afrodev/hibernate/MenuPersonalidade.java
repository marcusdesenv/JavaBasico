package br.com.afrodev.hibernate;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.afrodev.hibernate.models.Personalidade;
import br.com.afrodev.hibernate.models.dao.PersonalidadeDAO;
import br.com.afrodev.hibernate.util.Leitor;

public class MenuPersonalidade {

	public static void main(String[] args) {
		// CRIA A OPÇAO DE 1) CADASTRAR, 2) EDITAR , 3) DELETAR , 4) BUSCAR POR NOME

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("afrodev");
		EntityManager em = emf.createEntityManager();
		PersonalidadeDAO personalidadeDAO = new PersonalidadeDAO(em);
		Scanner sc = new Scanner(System.in);
		Integer opcao = 0;
		do {
			opcao = Leitor.lerValor("1) CADASTRAR\n2) EDITAR \n3) DELETAR \n4) BUSCAR POR NOME\n5) BUSCAR TODOS\n", sc,
					0);
			System.out.println("\n--------------------------\n");
			switch (opcao.intValue()) {
			case 1:
				em.getTransaction().begin();
				cadastrar(personalidadeDAO, sc);
				em.getTransaction().commit();
				break;

			case 2:
				em.getTransaction().begin();
				editar(personalidadeDAO, sc);
				System.out.println("\n--------------------------\n");
				em.getTransaction().commit();
				break;

			case 3:
				em.getTransaction().begin();
				deletar(personalidadeDAO, sc);
				System.out.println("\n--------------------------\n");
				em.getTransaction().commit();
				break;

			case 4:
				Personalidade per = buscarPorNome("Qual o identificador da Personalidade deseja selecionar?",
						personalidadeDAO, sc);
				System.out.println(per == null ? "Não encontrado" : per);
				System.out.println("\n--------------------------\n");
				break;
			case 5:
				buscarTodos(personalidadeDAO);

				break;
			default:
				break;
			}
		} while (opcao != 0);

	}

	private static void buscarTodos(PersonalidadeDAO personalidadeDAO) {
		List<Personalidade> personalidades = personalidadeDAO.consultarTodos();
		personalidades.forEach(personalidade -> {
			System.out.println(personalidade);
		});

	}

	private static void deletar(PersonalidadeDAO personalidadeDAO, Scanner sc) {
		Personalidade p = buscarPersonalidade("Qual o identificador da Personalidade deseja deletar ?",
				personalidadeDAO, sc);
		if (p != null) {
			personalidadeDAO.deletar(p);
		}

	}

	private static void editar(PersonalidadeDAO personalidadeDAO, Scanner sc) {

		Personalidade p = buscarPersonalidade("Qual o identificador da Personalidade deseja selecionar para edição ? ",
				personalidadeDAO, sc);
		if (p != null) {
			String nome = Leitor.lerValor("Qual o novo nome da personalidade ? ", sc);
			p.setNome(nome == null || nome.trim().equals("") ? p.getNome() : nome);
			personalidadeDAO.salvar(p);
		}
	}

	private static Personalidade buscarPersonalidade(String pergunta, PersonalidadeDAO personalidadeDAO, Scanner sc) {
		Integer opcaoDeBusca = 0;
		Personalidade p = null;
		do {
			opcaoDeBusca = Leitor.lerValor("1) Buscar por Nome\n2) Buscar por Identificador\n", sc, 0);
			System.out.println("\n--------------------------\n");
			switch (opcaoDeBusca.intValue()) {
			case 1:
				p = buscarPorNome(pergunta, personalidadeDAO, sc);
				break;
			case 2:
				p = buscarPorIdentificador(personalidadeDAO, sc);
				if (p == null) {
					System.out.println("Nenhum registro encontrado..");
				}
				break;

			default:
				break;
			}
		} while (opcaoDeBusca != 0);

		return p;
	}

	private static Personalidade buscarPorIdentificador(PersonalidadeDAO personalidadeDAO, Scanner sc) {

		return personalidadeDAO.consultarPorIdt(Leitor.lerValor("Qual o identificador da Personalidade ?", sc, 0L));
	}

	private static Personalidade buscarPorNome(String pergunta, PersonalidadeDAO personalidadeDAO, Scanner sc) {
		List<Personalidade> personalidades = personalidadeDAO
				.consultarPorNome(Leitor.lerValor("Informe parte do nome para buscar a personalidade:", sc));

		if (personalidades.size() == 1) {
			return personalidades.get(0);
		} else if (personalidades.size() > 1) {
			System.out.println("Foram encontrador esses registros:");
			personalidades.forEach(personalidade -> {
				System.out.println(personalidade);
			});
			Long identificador = Leitor.lerValor(pergunta, sc, 0L);
			Personalidade selecionado = null;
			for (int i = 0; i < personalidades.size(); i++) {
				if (identificador.equals(personalidades.get(i).getIdt())) {
					selecionado = personalidades.get(i);
				}
			}
			return selecionado;
		} else {
			return null;
		}
	}
	
	public static Personalidade buscarPorNomeExato(PersonalidadeDAO personalidadeDAO, String nome) {
		Personalidade personalidade = personalidadeDAO
				.consultarPorNomeExato(nome);
	
		return personalidade;
	}

	
	
	
	private static void cadastrar(PersonalidadeDAO personalidadeDAO, Scanner sc) {

		Personalidade p = new Personalidade();
		p.setNome(Leitor.lerValor("Qual o nome da nova personalidade?", sc));
		personalidadeDAO.salvar(p);

	}
}
