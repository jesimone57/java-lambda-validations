package com.jplanes.blog.examples.model.validator;

public class OldFashionedPersonValidatorTest extends AbstractPersonValidatorTest {

	@Override
	protected IPersonValidator getValidatorInstance() {
		return new OldFashionedPersonValidator();
	}

}
