package code.mihael.query;

import code.mihael.query.animal.Animal;
import code.mihael.query.animal.Gender;
import code.mihael.query.api.Functions;
import code.mihael.query.person.Person;

public class Main {

	public static void main(String... args) {
		long start = System.currentTimeMillis();

		Person p = Person.newQuery().names("Mihael").results().first();
		Person r = Person.newQuery().ages(99).results().random();
		
		Animal.newQuery().genders(Gender.FEMALE).results().asList().forEach(a -> {
			System.out.println(a.getName());
		});

		long stop = System.currentTimeMillis();
		long duration = stop - start;

		System.out.println(Functions.getTime(duration, true));
	}
}
