package br.com.afrodev.hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.afrodev.hibernate.models.Personalidade;
import br.com.afrodev.hibernate.models.Pessoa;
import br.com.afrodev.hibernate.models.Sexo;

public class App {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("afrodev");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Pessoa p = new Pessoa();
		p.setNome("Mariazinha");
		p.setIdade(30);
		p.setSexo(Sexo.FEMININO);
		List<Personalidade> personalidades = new ArrayList<Personalidade>();
		personalidades.add(new Personalidade("Seguro"));
		for (int i = 0; i < personalidades.size(); i++) {
			em.persist(personalidades.get(i));
		}
		p.setPersonalidades(personalidades);
		em.persist(p);
		em.getTransaction().commit();
		em.getTransaction().begin();

		TypedQuery<Pessoa> q = em.createQuery("SELECT p FROM Pessoa p where p.nome = :pNome ", Pessoa.class);

		q.setParameter("pNome", "Mariazinha");
		List<Pessoa> pessoas = q.getResultList();

		for (Pessoa pessoa : pessoas) {
			System.out.println(p);
			em.remove(pessoa);
		}
		em.getTransaction().commit();
		em.close();
	}
}
