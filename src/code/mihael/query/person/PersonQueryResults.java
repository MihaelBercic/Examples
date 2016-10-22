package code.mihael.query.person;

import java.util.List;

import code.mihael.query.api.Functions;
import code.mihael.query.api.QueryResults;

public class PersonQueryResults extends QueryResults {

	private List<Person> results;

	public PersonQueryResults(List<Person> results) {
		super();
		this.results = results;
	}

	public Person first() {
		return results.size() > 0 ? results.get(0) : null;
	}

	public Person random() {
		return results.size() > 0 ? results.get(Functions.random(0, results.size())) : null;
	}

}
