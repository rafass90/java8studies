package com.concrete;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class OrderRandomJ8 {

	public static void main(String[] args) {
		Path path = Paths.get("/home", "rafael", "Documentos", "teste.txt");

		Map<Character, List<String>> onDictionary  = new HashMap<Character, List<String>>();

		try (Stream<String> words = Files.lines(path)){
			Instant begin1 =  Instant.now(); 
			words
			.peek(w -> {
//				System.out.println(Thread.currentThread().getName());
				if(!onDictionary.containsKey(w.charAt(0)))
					onDictionary.put(w.charAt(0), new ArrayList<String>());
				onDictionary.get(w.charAt(0)).add(w);
			});

			Instant end1 =  Instant.now();
			Instant begin2 =  Instant.now();
			onDictionary.forEach((c, w) -> sendToFile(w, c));
			Instant end2 =  Instant.now();

			System.out.println("readFile"+ Duration.between(begin1, end1));
			System.out.println("sendToFiles"+ Duration.between(begin2, end2));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void sendToFile(List<String> words, char prefixFile){
		Path path = Paths.get("/home", "rafael", "Documentos", "random", prefixFile + ".txt");

		try (BufferedWriter writer = Files.newBufferedWriter(path)) 
		{
			words.stream().forEach(w -> {
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
