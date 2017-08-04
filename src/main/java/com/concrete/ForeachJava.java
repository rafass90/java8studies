package com.concrete;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class ForeachJava {

	public static void main(String[] args) {

		Stream.iterate("+", s -> s + "+").limit(10).forEach(System.out::println);
		
		
		System.out.println("  ");
		
		List<String> threadSafe = new CopyOnWriteArrayList<>();
		List<String> nonThreadSafe = new ArrayList<>();
		
		Stream.iterate("+", s -> s + "+")
			.parallel()
			.limit(10000)
			.peek(t -> System.out.println("_____" + Thread.currentThread().getName()))
			.forEach(s -> System.out.println(Thread.currentThread().getName()));
	}
}
