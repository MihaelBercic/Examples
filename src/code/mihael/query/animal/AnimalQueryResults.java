package code.mihael.query.animal;

import java.util.List;
import java.util.function.Consumer;

import code.mihael.query.api.Functions;
import code.mihael.query.api.QueryResults;

public class AnimalQueryResults extends QueryResults<Animal> {

	private List<Animal> accepted;
	private int size;

	public AnimalQueryResults(List<Animal> accepted) {
		this.accepted = accepted;
		size = accepted.size();
	}

	@Override
	public Animal first() {
		return size > 0 ? accepted.get(0) : null;
	}

	@Override
	public Animal random() {
		return size > 0 ? accepted.get(Functions.random(0, size)) : null;
	}

	@Override
	public List<Animal> asList() {
		return accepted;
	}

	@Override
	public void forEach(Consumer<Animal> args) {
		accepted.forEach(a -> args.accept(a));
	}

}
