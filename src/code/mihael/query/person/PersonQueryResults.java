package code.mihael.query.person;

import java.util.List;
import java.util.function.Consumer;

import code.mihael.query.api.Functions;
import code.mihael.query.api.QueryResults;

public class PersonQueryResults extends QueryResults<Person> {

	private List<Person> results;
	private int size = 0;

	public PersonQueryResults(List<Person> results) {
		super();
		this.results = results;
		size = results.size();
	}

	@Override
	public Person first() {
		return size > 0 ? results.get(0) : null;
	}

	@Override
	public Person random() {
		return size > 0 ? results.get(Functions.random(0, size)) : null;
	}

	@Override
	public List<Person> asList() {
		return results;
	}

	@Override
	public void forEach(Consumer<Person> args) {
		results.forEach(a -> args.accept(a));
	}
}
