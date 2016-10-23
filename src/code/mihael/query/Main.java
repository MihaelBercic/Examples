package code.mihael.query;

import java.util.regex.Pattern;

import code.mihael.query.animal.Animal;
import code.mihael.query.animal.Gender;
import code.mihael.query.api.StopWatch;
import code.mihael.query.person.Person;
import code.mihael.query.person.PersonQueryResults;

public class Main {

	public static void main(String... args) {
		StopWatch timer = new StopWatch();
		timer.start();

		/* People query examples */

		Person p = Person.newQuery().names("Mihael").results().first();
		PersonQueryResults r = Person.newQuery().ages(99, 17).results();
		Person randomPerson = r.random();
		/* Animals query examples */

		Animal.newQuery().filter(animal -> animal.getGender().equals(Gender.APACHE_HELICOPTER)).results().forEach(a -> System.out.println(a.getAge()));
		Animal.newQuery().ages(a -> a > 0 && a < 100).names(Pattern.compile("Do.*")).results().asList().forEach(a -> {
			System.out.println(a.getName() + " is " + a.getAge() + (a.getAge() > 1 ? " years old." : " year old.") + " " + a.getName() + " is " + a.getGender().toString());
		});
		
		Animal.newQuery().genders(Gender.APACHE_HELICOPTER).results().first();

		timer.stop();
		System.out.println(timer.getDurationAsString(true));
	}
}
