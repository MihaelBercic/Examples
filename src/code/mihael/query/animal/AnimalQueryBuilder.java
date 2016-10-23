package code.mihael.query.animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import code.mihael.query.api.QueryBuilder;

public class AnimalQueryBuilder extends QueryBuilder<Animal> {

	private int[] ages;
	private String[] names;
	private Gender[] genders;
	private Pattern namePattern;
	private Predicate<Integer> agesPredicate;
	private Predicate<Animal> animalPredicate;

	private List<Animal> animals = new ArrayList<>();

	public AnimalQueryBuilder() {
		Collections.addAll(animals, new Animal("Doge", 1, Gender.MALE), new Animal("Dogi", 2, Gender.FEMALE), new Animal("Heli", 9, Gender.APACHE_HELICOPTER), new Animal("Jo", 3, Gender.FEMALE));
	}

	public AnimalQueryBuilder names(String... names) {
		this.names = names;
		return this;
	}

	public AnimalQueryBuilder ages(int... ages) {
		Arrays.sort(ages);
		this.ages = ages;
		return this;
	}

	public AnimalQueryBuilder ages(Predicate<Integer> ages) {
		this.agesPredicate = ages;
		return this;
	}

	public AnimalQueryBuilder genders(Gender... genders) {
		this.genders = genders;
		return this;
	}

	public AnimalQueryBuilder names(Pattern pattern) {
		this.namePattern = pattern;
		return this;
	}

	public AnimalQueryBuilder filter(Predicate<Animal> animalPredicate) {
		this.animalPredicate = animalPredicate;
		return this;
	}

	@Override
	public AnimalQueryResults results() {
		List<Animal> accepted = animals.stream().filter(a -> {

			if (names != null && Arrays.binarySearch(names, a.getName()) < 0) {
				return false;
			}

			if (ages != null && Arrays.binarySearch(ages, a.getAge()) < 0) {
				return false;
			}

			if (genders != null && !Arrays.asList(genders).contains(a.getGender())) {
				return false;
			}

			if (namePattern != null) {
				Matcher m = namePattern.matcher(a.getName());
				if (!m.matches()) {
					return false;
				}
			}

			if (agesPredicate != null && !agesPredicate.test(a.getAge())) {
				return false;
			}

			if (animalPredicate != null && !animalPredicate.test(a)) {
				return false;
			}

			return true;
		}).collect(Collectors.toList());
		return new AnimalQueryResults(accepted);
	}

}
