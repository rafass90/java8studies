package com.concrete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MathTest{

	static Function<Double, Optional<Double>> sqrtFunction = NewMath::sqrt;
	static Function<Double, Optional<Double>> invFunction = NewMath::inv;
	static Predicate<Optional<Double>> filterIsPresent = o -> o.isPresent();

	public static void main(String[] args) {
		List<Double> doubles = Arrays.asList(0d, 1d, 1.4d, 2d, 4d , 9d, 25d);
		List<Double> result = new ArrayList<>();

		result = doubles.stream()
				.map(sqrtFunction)
				.filter(filterIsPresent)
				//				.map(o -> o.get())
				//				.map(invFunction)
				.map(o -> o.get())
				.collect(Collectors.toList());

		result.forEach(System.out::println);

	}
}

/*package*/ class NewMath{

	static Optional<Double> sqrt(Double d){
		return d > 0d? Optional.of(Math.sqrt(d)): Optional.empty();
	}

	static Optional<Double> inv(Double d){
		return d != 0d? Optional.of(1d/d): Optional.empty();
	}
}
