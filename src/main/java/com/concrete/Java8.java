package com.concrete;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Java8 {

	static Function<Path, Stream<String>> streamString = t -> {
		try {
			return Files.lines(t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	};

	static Consumer<Object> print = System.out::println;

	static Predicate<Path> filterPeopleFiles = file -> file.getFileName().toString().contains("people.txt");

	public static void main(String[] args) {
		Instant begin = Instant.now();

		getListsNew(Paths.get("/home", "rafael", "Documentos", "random"));

		Instant end = Instant.now();
		System.out.println("Tempo(ms): " + Duration.between(begin, end).toMillis());

	}

	private static void getListsNew(Path dir) {
		try {
			Files.list(dir)
			.map(path -> {
				try {
					return Files.lines(path);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				return null;
			})
//			.unordered()
//			.parallel()
			.forEach(c -> {
				createFileOrdered(c.collect(Collectors.toList()).stream().collect(Collectors.toList()));	
			})
//			.forEach(d -> {})
			;
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static void createFileOrdered(List<String> words) {
		Path path = Paths.get("/home", "rafael", "Documentos", "ordered", String.valueOf(words.stream().findAny().get().charAt(0)) + ".txt");

//		System.out.println(Thread.currentThread().getName());
		try (BufferedWriter writer = Files.newBufferedWriter(path)) 
		{
			words
			.parallelStream()
//			.stream()
			.sorted()
//			.unordered()
//			.parallel()
			.forEach(w -> {
				try {
					writer.write(w);
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			})
//			.forEach(d -> System.out.println("word " + Thread.currentThread().getName()));
			;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
