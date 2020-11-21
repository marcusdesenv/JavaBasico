package br.com.dao.inter;

import java.util.ArrayList;

import br.com.models.Animal;

public interface AnimalDAOInterface {

	public Animal buscarAnimal(Long identificador);

	public Animal buscarAnimalPorNome(String nome);

	public int deletarAnimal(Animal animal);

	public int cadastrarAnimal(Animal animal);

	public int cadastrarAnimal(ArrayList<Animal> animais);

	public ArrayList<Animal> consultarAnimais();

	public int deletarAnimal(ArrayList<Animal> animais);
}
