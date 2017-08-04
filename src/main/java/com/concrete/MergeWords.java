package com.concrete;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeWords {

	private static String word1 = "JAVAMASTERRACE";
	private static String word2 = "palmeiras";
	
	
	public static void main(String[] args) {
		String mergedWord;
		
//		word1.chars().flatMap(word2.chars()).

		Stream<String> st1 = Arrays.asList("c", "b").stream();
		Stream<String> st2 = Arrays.asList("A", "D").stream();

		IntStream.concat(word1.chars(), word2.chars()).forEach( a -> System.out.printf(String.valueOf(a)));
//		strema.forEachOrdered(System.out::print);
	}
}
