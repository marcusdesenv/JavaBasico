package br.com.afrodev.hibernate.models.idao;

import java.util.List;

import br.com.afrodev.hibernate.models.Pessoa;

public interface IPessoaDAO {


	void deletar(Pessoa p);

	List<Pessoa> consultarPorNome(String nome);

	Pessoa consultarPorIdt(Long idt);

	void salvar(Pessoa p);

	List<Pessoa> consultarTodos();
}
