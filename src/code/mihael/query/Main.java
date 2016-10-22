package code.mihael.query;

import code.mihael.query.api.Functions;

public class Main {

	public static void main(String... args) {
		long start = System.currentTimeMillis();
		
		Person p = Person.newQuery().names("Mihael").results().first();
		System.out.println(p.getName() + " -> " + p.getAge());

		Person r = Person.newQuery().ages(99).results().random();
		if (r != null) {
			System.out.println(r.getName() + " -> " + r.getAge());
		}
		
		
		long stop = System.currentTimeMillis();
		long duration = stop - start;
		
		System.out.println(Functions.getTime(duration, true));
	}
}
