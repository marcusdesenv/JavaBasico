package br.com.afrodev.hibernate.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.afrodev.hibernate.models.Personalidade;
import br.com.afrodev.hibernate.models.Pessoa;
import br.com.afrodev.hibernate.models.idao.IPessoaDAO;

public class PessoaDAO implements IPessoaDAO {

	private EntityManager em;

	private static String SQLCONSULTARPORNOME = "SELECT p FROM Pessoa p where p.nome like :pNome  ";

	public PessoaDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(Pessoa p) {
		this.em.persist(p);
	}

	@Override
	public void deletar(Pessoa p) {
		this.em.remove(p);
	}

	@Override
	public List<Pessoa> consultarPorNome(String nome) {
		TypedQuery<Pessoa> q = em.createQuery(this.SQLCONSULTARPORNOME, Pessoa.class);
		q.setParameter("pNome", nome);
		List<Pessoa> pessoas = q.getResultList();
		return pessoas;
	}

	@Override
	public Pessoa consultarPorIdt(Long idt) {
		return this.em.find(Pessoa.class, idt);
	}

	private static String SQLCONSULTARTODOS = "SELECT p FROM Pessoa p";

	@Override
	public List<Pessoa> consultarTodos() {
		TypedQuery<Pessoa> q = em.createQuery(this.SQLCONSULTARTODOS, Pessoa.class);
		List<Pessoa> pessoas = q.getResultList();
		return pessoas;
	}

}
