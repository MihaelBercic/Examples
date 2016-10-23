package code.mihael.query.animal;

import code.mihael.query.api.Functions;

public enum Gender {
	MALE,
	FEMALE,
	APACHE_HELICOPTER;

	@Override
	public String toString() {
		return Functions.capitalize(this.name()).toLowerCase();
	}
}
