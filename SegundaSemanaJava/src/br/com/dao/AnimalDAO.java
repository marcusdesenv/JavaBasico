package br.com.dao;

import java.util.ArrayList;

import br.com.dao.inter.AnimalDAOInterface;
import br.com.models.Animal;

public class AnimalDAO implements AnimalDAOInterface {

	private ArrayList<Animal> animais;

	public AnimalDAO() {

		this.animais = new ArrayList<>();
	}

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}

	@Override
	public Animal buscarAnimal(Integer identificador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animal buscarAnimalPorNome(String nome) {
		Animal retorno = null;
		for (Animal a : animais) {
			if (a.getNome().toUpperCase().equals(nome.toLowerCase())) {

			}
		}
		return retorno;
	}

	@Override
	public int deletarAnimal(Animal animal) {
		if (animal != null) {
			this.animais.remove(animal);
			return 1;
		}
		return 0;
	}

	@Override
	public int deletarAnimal(ArrayList<Animal> animais) {
		if (animais.size() > 0) {
			this.animais.removeAll(animais);
			return 1;
		}
		return 0;
	}

	@Override
	public int cadastrarAnimal(Animal animal) {
		if (animal != null) {
			this.animais.add(animal);
			return 1;
		}
		return 0;
	}

	@Override
	public int cadastrarAnimal(ArrayList<Animal> animais) {
		if (animais.size() > 0) {
			this.animais.addAll(animais);
			return 1;
		}
		return 0;
	}

	@Override
	public ArrayList<Animal> consultarAnimais() {
		// TODO Auto-generated method stub
		return animais;
	}

}
