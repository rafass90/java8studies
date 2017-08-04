package com.concrete;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoinFiles{

	static Consumer<Object> print = System.out::println;

	static Predicate<Path> filterPeopleFiles = file -> file.getFileName().toString().contains("people.txt");

	public static void main(String[] args) throws InterruptedException {
		sendToFile(() -> getListsNew(Paths.get("/home", "rafael", "Documentos", "random")).stream());
	}

	private static List<String> getListsNew(Path dir) {
		try {
			System.out.println("getListsNew");
				return	Files.list(dir).parallel()
					.map(path -> {
						try {
							return Files.lines(path).sorted();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						return null;
					})
					.flatMap(Function.identity())
					.collect(Collectors.toList())
	//							.unordered()
	//							.parallel()
					//					.sorted()
			;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public static void sendToFile(Supplier <? extends Stream<String>> words){
		Path path = Paths.get("/home", "rafael", "Documentos", "randomresult.txt");
		System.out.println("sendToFile");
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			words.get().forEach(w -> {
				try {
					writer.write(w);
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
