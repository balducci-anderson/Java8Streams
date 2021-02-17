package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Java8Streams {

	public static void main(String[] args) {

		List<Cidade> cidades = new ArrayList<Cidade>();
		
		cidades.add(new Cidade("Rio de Janeiro", 275000));
		cidades.add(new Cidade("São Paulo", 491006));
		cidades.add(new Cidade("Amapá", 38051));
		cidades.add(new Cidade("Goiânia", 103917));
		
		System.out.println("Lista de cidades original");
		cidades.forEach(c -> System.out.println(c.getNome() + " " + c.getHabitantes()));
		
		
		System.out.println("\nCidades com mais de 200.000 habitantes");
		cidades.stream()
			.filter(c -> c.getHabitantes() > 200000)
			.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println("\nQuantidade de habitantes: Cidades Filtradas");
		
		cidades.stream()
			.filter(c -> c.getHabitantes() > 200000)
			.mapToInt(Cidade::getHabitantes)
			.forEach(System.out::println);
		
		System.out.println("\nMédia de Habitantes: Cidades Filtradas");
		
		cidades.stream()
			.filter(c -> c.getHabitantes() > 200000)
			.mapToInt(Cidade::getHabitantes)
			.average();
		
		System.out.println("\nCidades Filtradas: utilizando Optional<Cidade>");
		
		Optional<Cidade> primeiraCidade = cidades.stream()
			.filter(c -> c.getHabitantes() > 200000)
			.findFirst();
		
		primeiraCidade.ifPresent(c -> System.out.println("Habitantes: " + c));
	}

}

class Cidade {
	
	private String nome;
	private int habitantes;
	
	public Cidade(String nome, int habitantes) {
		this.nome = nome;
		this.habitantes = habitantes;
	}
	
	public String getNome() {
		return nome;
	}
	public int getHabitantes() {
		return habitantes;
	}	
}

