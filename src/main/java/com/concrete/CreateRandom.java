package com.concrete;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class CreateRandom {

	public static void main(String[] args) {
		final String alphabet = "abcdefghijklmnopqrstuvxwyzABCDEFGHIJKLMNOPQRSTUVXWYZ";
		final int N = alphabet.length();;

		Instant begin = Instant.now();
		Random r = new Random();

		Path path = Paths.get("/home", "rafael","Documentos", "teste.txt");

		createWithStringBuilder(alphabet, N, r, path);
		Instant end = Instant.now();
		System.out.println("FIM\nTempo: " + Duration.between(begin, end).toMillis());
		
	}
	
	private static void createWithString(final String alphabet, final int N, Random r, Path path) {
		try (BufferedWriter writer = Files.newBufferedWriter(path)) 
		{
			String randomWord;
			for(Long a = 0l; a < 60000000l; a++){
				randomWord = new String();
				while(randomWord.length() < 8){
					randomWord = randomWord.concat(String.valueOf(alphabet.charAt(r.nextInt(N))));	
				}
				writer.write(randomWord);
//				if(a % 4000000 == 0)
//					System.out.println(a);	
				writer.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createWithStringBuffer(final String alphabet, final int N, Random r, Path path) {
		try (BufferedWriter writer = Files.newBufferedWriter(path)) 
		{
			StringBuffer randomWord;
			for(Long a = 0l; a < 60000000l; a++){
				randomWord = new StringBuffer();
				while(randomWord.length() < 8){
					randomWord = randomWord.append(String.valueOf(alphabet.charAt(r.nextInt(N))));	
				}
				writer.write(randomWord.toString());
//				if(a % 4000000 == 0)
//					System.out.println(a);	
				writer.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void createWithStringBuilder(final String alphabet, final int N, Random r, Path path) {
		try (BufferedWriter writer = Files.newBufferedWriter(path)) 
		{
			StringBuilder randomWord;
			for(Long a = 0l; a < 60000000l; a++){
				randomWord = new StringBuilder();
				while(randomWord.length() < 8){
					randomWord = randomWord.append(String.valueOf(alphabet.charAt(r.nextInt(N))));	
				}
				writer.write(randomWord.toString());
//				if(a % 4000000 == 0)
//					System.out.println(a);	
				writer.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}