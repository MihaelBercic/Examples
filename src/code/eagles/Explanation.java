package code.eagles;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Explanation {

	public List<Item> packItems(int capacity, List<Item> items) {
		AtomicInteger inside = new AtomicInteger(0);
		return items.stream().filter(e -> inside.get() != (inside.get() - inside.getAndAdd((inside.get() + e.getWeight() <= capacity ? e.getWeight() : 0)) + inside.get()))
				.collect(Collectors.toList());
	}

	
	
	/*
	 * inside.get() + e.getWeight() <= capacity -> if it can fit in there add
	 * weight to inside else add 0; inside.get() - inside.getAndAdd() = 0;
	 * 
	 * inside.get() + new inside.get() -> if they are not the same return true
	 * and add it to list. else return false and do not add them to the list.
	 */

}
