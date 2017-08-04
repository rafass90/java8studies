package com.concrete;

import java.util.Spliterator;
import java.util.function.Consumer;

public class PersonIterator implements Spliterator<Person> {

	private Spliterator<String> lineSpliterator;
	private String name;
	private int age;
	private String city;

	public PersonIterator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator = lineSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Person> action) {
		if(lineSpliterator.tryAdvance(line -> this.name = line) &&
				lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line)) &&
				lineSpliterator.tryAdvance(line -> this.city = line)){

			action.accept(new Person(name, age, city));
			return true;
		}else{
			return false;
		}
	}

	//Implement only for parallel execution
	@Override
	public Spliterator<Person> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		return lineSpliterator.estimateSize() / 3;
	}

	@Override
	public int characteristics() {
		return lineSpliterator.characteristics();
	}

}
