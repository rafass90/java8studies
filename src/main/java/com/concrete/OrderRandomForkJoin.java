package com.concrete;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class OrderRandomForkJoin {


	public static void main(String[] args) {

		Path path = Paths.get("/home", "rafael", "Documentos", "teste.txt");

			Instant begin =  Instant.now();
			ForkJoinPool forkJoinPool = new ForkJoinPool(8);
			try {
				forkJoinPool.submit(() ->
				{try (Stream<String> words = Files.lines(path)){
					 
					words
					.unordered()
					.parallel()
//					.sorted()
					.forEach(s -> {});

					Instant end =  Instant.now();
				} catch (IOException e) {
					e.printStackTrace();
				}
				}).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			Instant end =  Instant.now();

			System.out.println(Duration.between(begin, end));
	}
}