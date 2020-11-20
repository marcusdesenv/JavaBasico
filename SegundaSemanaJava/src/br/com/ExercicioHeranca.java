package br.com;

import java.util.ArrayList;

import br.com.models.Animal;
import br.com.models.Cachorro;
import br.com.models.Galinha;
import br.com.models.Gato;

public class ExercicioHeranca {

	public static void main(String[] args) {
		// System.out.print("Teste".toUpperCase().contains("T"));
		ArrayList<Animal> arrayListAnimais = new ArrayList<>();
		Gato g = new Gato();
		arrayListAnimais.add(new Cachorro());
		arrayListAnimais.add(new Galinha());
		arrayListAnimais.add(g);

		for (Animal a : arrayListAnimais) {
			
		}
		arrayListAnimais.forEach(data -> {
			data.setIdade(10);
			data.dizerOla();
		});
		for (int i = 0; i < arrayListAnimais.size(); i++) {
			if (arrayListAnimais.get(i) instanceof Gato) {
				arrayListAnimais.remove(arrayListAnimais.get(i));
				i--;
			}
			System.out.println(arrayListAnimais.get(i).getNome());
		}
		// instanceof é usado para comparação de tipos

		// Pessoa p = new Pessoa();
		// Livro l = new Livro();
		// p.setNome("Pessoa");
		// l.setNome("Livro");
		// System.out.println(p.getNome());
		// System.out.println(l.getNome());

	}

}
