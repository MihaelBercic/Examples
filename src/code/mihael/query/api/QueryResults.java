package code.mihael.query.api;

import java.util.List;

public abstract class QueryResults<T> {

	public abstract T first();

	public abstract T random();
	
	public abstract List<T> asList();

}
