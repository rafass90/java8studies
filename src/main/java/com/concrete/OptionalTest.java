package com.concrete;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import com.sun.javafx.scene.control.behavior.OptionalBoolean;

public class OptionalTest {

	
	public static void main(String[] args) {
		Optional<String> optStrEmpty = Optional.empty();
		Optional<String> optStrNull = Optional.ofNullable(null);
		Optional<String> optStr = Optional.of("");// null will throw Exception here
		
		OptionalInt optInt = OptionalInt.empty();
		OptionalDouble optDouble = OptionalDouble.empty();
		OptionalLong optLong = OptionalLong.empty();
		OptionalBoolean optBoolean = OptionalBoolean.ANY;//Can be TRUE or FALSE too
	}
}
