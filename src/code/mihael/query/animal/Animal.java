package code.mihael.query.animal;

public class Animal {

	private String name;
	private int age;
	private Gender gender;

	public Animal(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public static AnimalQueryBuilder newQuery() {
		return new AnimalQueryBuilder();
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

}
