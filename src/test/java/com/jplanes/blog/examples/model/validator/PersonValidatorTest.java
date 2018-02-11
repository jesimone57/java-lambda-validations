package com.jplanes.blog.examples.model.validator;

public class PersonValidatorTest extends AbstractPersonValidatorTest {

	@Override
	protected IPersonValidator getValidatorInstance() {
		return new PersonValidator();
	}

}
