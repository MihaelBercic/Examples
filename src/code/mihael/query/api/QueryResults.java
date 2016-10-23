package code.mihael.query.api;

import java.util.List;
import java.util.function.Consumer;

public abstract class QueryResults<T> {

	public abstract T first();

	public abstract T random();

	public abstract List<T> asList();

	public abstract void forEach(Consumer<T> args);

}
