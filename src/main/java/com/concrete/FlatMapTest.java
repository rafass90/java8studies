package com.concrete;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FlatMapTest {

	static Consumer<Object> print = System.out::println;

	static Function<String, Stream<String>> splitIntoWords = 
			//			line -> Stream.of(line.split(" "));
			line -> Pattern.compile(" ").splitAsStream(line);
			
			Consumer<String> consTest = System.out::println;
			BiConsumer<String, String> biConsTest = (x, y) -> System.out.println( x + y );
			

			Predicate<String> tes = s -> true;
			
			public static void main(String[] args) {
				String[] words = new String[]{"Tem cerTeza man?", "Está certo?", "Obrigado", "Não sei", "Tese into", "Java man"};

				Stream<String> a = splitIntoWords.apply("teste");
				Stream<String> b = splitIntoWords.apply("      A B C D a b      c d Tem cerTeza man? Está certo? Obrigado Não sei Tese into Java man");
				Stream<String> c = splitIntoWords.apply("fsdfd fdf sdvsv adasd ");

//				a.filter(predicate)
				
				List<String> array = new ArrayList<String>();
				array.add("Bom dia");
				
				Stream<String> d = array.stream();
				Stream.of(a,b,c, d).flatMap(Function.identity()).flatMap(splitIntoWords).sorted().forEach(print);
//				Stream.of(a,b,c, d).flatMap(strem -> strem).forEach(print);
//				Stream.of(a,b,c, d).flatMap(Function.identity()).forEach(print);
//				Stream.of(words).flatMap(Function.identity()).forEach(print);ERRO COMPILAÇÃO
//				Stream.of(words).flatMap(splitIntoWords).forEach(print);
				
//				Set<String> set = c.collect(Collectors.toSet());
//				List<String> list = c.collect(Collectors.toList());
			}
			
			
			boolean isNullOrEmpty(String test){
				return true;
			}
}
