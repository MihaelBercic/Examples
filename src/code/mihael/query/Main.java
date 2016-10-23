package code.mihael.query;

import java.util.regex.Pattern;

import code.mihael.query.animal.Animal;
import code.mihael.query.animal.AnimalQueryResults;
import code.mihael.query.animal.Gender;
import code.mihael.query.person.Person;
import code.mihael.query.person.PersonQueryResults;

public class Main {

	public static void main(String... args) {
		/* People query examples */

		Person p = Person.newQuery().names("Mihael").results().first();
		PersonQueryResults r = Person.newQuery().ages(99, 17).results();
		Person randomPerson = r.random();
		/* Animals query examples */

		Animal.newQuery().filter(animal -> animal.getGender().equals(Gender.APACHE_HELICOPTER)).results().forEach(a -> System.out.println(a.getAge()));
		AnimalQueryResults results = Animal.newQuery().ages(a -> a > 0 && a < 100).names(Pattern.compile("Do.*")).results();
		Animal first = Animal.newQuery().genders(Gender.APACHE_HELICOPTER, Gender.FEMALE).results().first();

	}
}
