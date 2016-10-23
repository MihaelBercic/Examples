package code.mihael.query.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import code.mihael.query.api.Functions;
import code.mihael.query.api.QueryBuilder;

public class PersonQueryBuilder extends QueryBuilder<Person> {

	private List<Person> people = new ArrayList<>();

	private String[] name;
	private Pattern namePattern;
	private int[] age;
	private Predicate<Integer> agePredicate;
	private Predicate<Person> personPredicate;

	public PersonQueryBuilder() {
		Collections.addAll(people, new Person("Mihael", 17), new Person("Party", 99), new Person("Slash", 99), new Person("Savior", 99));
	}

	public PersonQueryBuilder names(String... names) {
		this.name = names;
		return this;
	}

	public PersonQueryBuilder names(Pattern pattern) {
		this.namePattern = pattern;
		return this;
	}

	public PersonQueryBuilder ages(int... ages) {
		Arrays.sort(ages);
		this.age = ages;
		return this;
	}

	public PersonQueryBuilder ages(Predicate<Integer> ages) {
		this.agePredicate = ages;
		return this;
	}

	public PersonQueryBuilder filter(Predicate<Person> predicatePerson) {
		this.personPredicate = predicatePerson;
		return this;
	}

	@Override
	public PersonQueryResults results() {

		List<Person> accepted = people.stream().filter(a -> {
			if (name != null && Arrays.binarySearch(name, a.getName()) < 0) {
				return false;
			}

			if (age != null && Arrays.binarySearch(age, a.getAge()) < 0) {
				System.out.println(~Arrays.binarySearch(age, a.getAge()));
				System.out.println(Functions.arrayContains(age, a.getAge()));
				System.out.println(a.getName() + " -> Does not suite.");
				return false;
			}

			if (namePattern != null) {
				Matcher m = namePattern.matcher(a.getName());
				if (!m.matches()) {
					return false;
				}
			}

			if (agePredicate != null && !agePredicate.test(a.getAge())) {
				return false;
			}

			if (personPredicate != null && !personPredicate.test(a)) {
				return false;
			}
			return true;
		}).collect(Collectors.toList());
		return new PersonQueryResults(accepted);
	}

}
