package com.concrete;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PeopleSpliterator {

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
		mergeFilesSample();
	}

	private static void mergeFilesSample() {

		Stream<String> lines = getListsOld(Paths.get("/home", "rafael", "Documentos"))
							.flatMap(Function.identity());		

		Stream<String> lists = getListsNew(Paths.get("/home", "rafael", "Documentos"));
//		Spliterator<String> spliterator = lines.spliterator();
//		Spliterator<Person> peopleSpliterator = new PersonIterator(spliterator);

//		Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);
		lists.forEach(print);

	}

	private static Stream<String> getListsNew(Path dir) {
		try {
			return Files.list(dir).filter(filterPeopleFiles).map(path -> {
				try {
					return Files.lines(path);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				return null;
			}).flatMap(Function.identity());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	private static Stream<Stream<String>> getListsOld(Path dir) {
		List<Stream<String>> listStreams = new ArrayList<Stream<String>>();
		
		try {
			Files.list(dir).filter(filterPeopleFiles).forEach(path -> {
				try {
					listStreams.add(Files.lines(path));
				} catch (IOException e) {
					e.printStackTrace();
				}	
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listStreams.stream();
	}


	private static void oneFileSample() {
		Path path = Paths.get("/home", "rafael", "Documentos", "people.txt");

		try(Stream<String> lines = Files.lines(path)){

			Spliterator<String> spliterator = lines.spliterator();
			Spliterator<Person> peopleSpliterator = new PersonIterator(spliterator);

			Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);
			people.forEach(print);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//	Function<Stream<Path>, Stream<String>> streamString = path -> Files.lines(path.); 
	//	
	//	Function<String, Stream<String>> splitIntoWords = line -> Stream.of(line.split(" "));
	//characteristics
	private static void nFilesSample() {
		Path dir = Paths.get("/home", "rafael", "Documentos");
		try (Stream<Path> pat = Files.list(dir).filter(filterPeopleFiles)){

			pat.forEach(path -> {
				try(Stream<String> lines = Files.lines(path)){

					Spliterator<String> spliterator = lines.spliterator();
					Spliterator<Person> peopleSpliterator = new PersonIterator(spliterator);

					Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);
					people.forEach(print);

				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}


}
