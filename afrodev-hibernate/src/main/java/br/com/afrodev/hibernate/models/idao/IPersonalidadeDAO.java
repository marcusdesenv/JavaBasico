package br.com.afrodev.hibernate.models.idao;

import java.util.List;

import br.com.afrodev.hibernate.models.Personalidade;

public interface IPersonalidadeDAO {

	
    void deletar(Personalidade p);

	List<Personalidade> consultarPorNome(String nome);

	Personalidade consultarPorIdt(Long idt);

	void salvar(Personalidade p);

	List<Personalidade> consultarTodos();

	Personalidade consultarPorNomeExato(String nome);
}
