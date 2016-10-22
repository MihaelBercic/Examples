package code.mihael.query.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import code.mihael.query.api.Functions;

public class PersonQueryBuilder {

	private List<Person> people = new ArrayList<>();

	private String[] name;
	private int[] age;

	public PersonQueryBuilder() {
		Collections.addAll(people, new Person("Mihael", 17), new Person("Party", 99), new Person("Slash", 99), new Person("Savior", 99));
	}

	public PersonQueryBuilder names(String... names) {
		this.name = names;
		return this;
	}

	public PersonQueryBuilder ages(int... ages) {
		this.age = ages;
		return this;
	}

	public PersonQueryResults results() {
		List<Person> accepted = people.stream().filter(a -> {
			boolean b = true;
			if (name != null) {
				b = b && Arrays.asList(name).contains(a.getName());
			}

			if (age != null) {
				b = b && Functions.arrayContains(age, a.getAge());
			}
			return b;
		}).collect(Collectors.toList());
		return new PersonQueryResults(accepted);
	}

}
