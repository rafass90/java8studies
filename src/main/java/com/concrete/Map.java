package com.concrete;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Map {

	public static void main(String[] args) {
		ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
		map.put("foo", "bar");
		map.put("han", "solo");
		map.put("r2", "d2");
		map.put("c3", "p0");
		
		map.forEach((k, v) -> System.out.printf("%s = %s\n", k, v));
		
		System.out.println(map.getOrDefault("foo", "teste"));
		
		map.merge("foo", "boo", (oldVal, newVal) -> newVal + " was " + oldVal);
		System.out.println(map.get("foo"));   // boo wa
		
		
//		String.joi
	}
}
