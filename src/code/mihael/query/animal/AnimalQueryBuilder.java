package code.mihael.query.animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import code.mihael.query.api.Functions;
import code.mihael.query.api.QueryBuilder;
import code.mihael.query.api.QueryResults;

public class AnimalQueryBuilder extends QueryBuilder<Animal> {

	private int[] ages;
	private String[] names;
	private Gender[] genders;

	private List<Animal> animals = new ArrayList<>();

	public AnimalQueryBuilder() {
		Collections.addAll(animals, new Animal("Doge", 1, Gender.MALE), new Animal("Dogi", 2, Gender.FEMALE), new Animal("Heli", 9, Gender.APACHE_HELICOPTER), new Animal("Jo", 3, Gender.FEMALE));
	}

	public AnimalQueryBuilder names(String... names) {
		this.names = names;
		return this;
	}

	public AnimalQueryBuilder ages(int... ages) {
		this.ages = ages;
		return this;
	}

	public AnimalQueryBuilder genders(Gender... genders) {
		this.genders = genders;
		return this;
	}

	@Override
	public QueryResults<Animal> results() {
		List<Animal> accepted = animals.stream().filter(a -> {
			boolean b = true;

			if (names != null) {
				b = b && Arrays.asList(names).contains(a.getName());
			}

			if (ages != null) {
				b = b && Functions.arrayContains(ages, a.getAge());
			}

			if (genders != null) {
				b = b && Arrays.asList(genders).contains(a.getGender());
			}

			return b;
		}).collect(Collectors.toList());
		return new AnimalQueryResults(accepted);
	}

}
