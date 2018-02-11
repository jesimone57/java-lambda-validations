package com.jplanes.blog.examples.validations.helper;

import com.jplanes.blog.examples.validations.SimpleValidation;
import com.jplanes.blog.examples.validations.Validation;

import static java.lang.String.format;

public class StringValidationHelpers {
	public static Validation<String> notNull = SimpleValidation.from(s -> s != null, "must not be null.");

	public static Validation<String> moreThan(int size) {
		return SimpleValidation.from(s -> s.length() >= size, format("must have more than %s chars.", size));
	}

	public static Validation<String> lessThan(int size) {
		return SimpleValidation.from(s -> s.length() <= size, format("must have less than %s chars.", size));
	}

	public static Validation<String> between(int minSize, int maxSize) {
		return moreThan(minSize).and(lessThan(maxSize));
	}

	public static Validation<String> contains(String c) {
		return SimpleValidation.from(s -> s.contains(c), format("must contain %s", c));
	}

	public static Validation<String> matches(String c) {
		return SimpleValidation.from(s -> c != null && s != null && s.equals(c), format("must match %s", c));
	}
}
