package br.com.afrodev.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.afrodev.hibernate.models.Personalidade;
import br.com.afrodev.hibernate.models.Pessoa;
import br.com.afrodev.hibernate.models.Sexo;
import br.com.afrodev.hibernate.models.dao.PersonalidadeDAO;
import br.com.afrodev.hibernate.models.dao.PessoaDAO;
import br.com.afrodev.hibernate.util.Leitor;

public class MenuPessoa {

	public static void main(String[] args) {
		// CRIA A OPÇAO DE 1) CADASTRAR , 2) TODOS
		// AO cadastrar tem que informar as personalidades.
		// E verificar se ela já existe no banco
		// Imprimir as Personalidades junto com a Pessoa.
		// 3) Deletar
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("afrodev");
		EntityManager em = emf.createEntityManager();
		PessoaDAO pessoaDAO = new PessoaDAO(em);
		PersonalidadeDAO personalidadeDAO = new PersonalidadeDAO(em);
		Scanner sc = new Scanner(System.in);
		Integer opcao = 0;
		do {
			opcao = Leitor.lerValor("1) CADASTRAR\n2) TODOS\n", sc, 0);
			System.out.println("\n--------------------------\n");
			switch (opcao.intValue()) {
			case 1:
				em.getTransaction().begin();
				cadastrar(personalidadeDAO, pessoaDAO, sc);
				em.getTransaction().commit();
				break;
			case 2:
				buscarTodos(pessoaDAO);
				break;
			default:
				break;
			}
		} while (opcao != 0);
	}

	private static void cadastrar(PersonalidadeDAO personalidadeDAO, PessoaDAO pessoaDAO, Scanner sc) {

		Pessoa p = new Pessoa();
		p.setNome(Leitor.lerValor("Qual o nome da pessoa ?", sc));
		p.setIdade(Leitor.lerValor("Qual a idade ?", sc, 0));
		Sexo sexoEnum = null;
		do {
			String sexo = Leitor.lerValor("Qual o sexo  (M/F) ?", sc);
			if (Sexo.FEMININO.getSigla().equals(sexo.toUpperCase())) {
				sexoEnum = Sexo.FEMININO;
			}
			if (Sexo.MASCULINO.getSigla().equals(sexo.toUpperCase())) {
				sexoEnum = Sexo.MASCULINO;
			}
		} while (sexoEnum == null);
		p.setSexo(sexoEnum);

		List<Personalidade> personalidades = new ArrayList<Personalidade>();

		Integer controleAdicionandoPersonalidade = 0;
		do {
			Boolean querAdicionarPersonalidade = Leitor.lerValor("Deseja adicionar uma personalidade a pessoa ?", sc,
					false);
			if (querAdicionarPersonalidade) {
				String nome = Leitor.lerValor("Informe o nome da personalidade:", sc);
				Personalidade personalidade = MenuPersonalidade.buscarPorNomeExato(personalidadeDAO, nome);

				if (personalidade != null) {
					personalidades.add(personalidade);
				} else {
					
					Personalidade novaPersonalidade = new Personalidade(nome);
					personalidadeDAO.salvar(novaPersonalidade);
					personalidades.add(novaPersonalidade);
				}
			}
		} while (controleAdicionandoPersonalidade != 0);

		p.setPersonalidades(personalidades);

		pessoaDAO.salvar(p);

	}

	private static void buscarTodos(PessoaDAO pessoaDAO) {

		List<Pessoa> pessoas = pessoaDAO.consultarTodos();
		pessoas.forEach(pessoa -> {
			System.out.println(pessoa);
		});

	}

}
