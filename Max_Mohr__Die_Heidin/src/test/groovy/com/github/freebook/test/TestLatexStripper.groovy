package com.github.freebook.test

import org.junit.Ignore
import org.junit.Test

import com.github.freebook.LatexStripper


class TestLatexStripper {
	
	public static LatexStripper latexStripper = new LatexStripper()
	
	@Test
	void emptyBracketsRemoved() {
		assert '' == latexStripper.stripString('{}')
	}
	
	@Test
	void emptyBracketsWithinCharactersRemoved() {
		assert 'abcdef' == latexStripper.stripString('abc{}def')
	}
	
	@Test
	void emptyBracketsWithinSpacesRemoved() {
		assert 'abc def' == latexStripper.stripString('abc {}def')
		assert 'abc def' == latexStripper.stripString('abc{} def')
	}
	
	@Test
	void bracketsWithSpaceRemoved() {
		assert ' ' == latexStripper.stripString('{ }')
	}
	
	@Test
	void bracketsWithTextRemoved() {
		assert 'hallo' == latexStripper.stripString('{hallo}')
	}
	
	@Test
	void bracketsWithTextWithinCharactersRemoved() {
		assert 'abchallodef' == latexStripper.stripString('abc{hallo}def')
	}
	
	@Test
	void bracketsWithTextWithinSpacesRemoved() {
		assert 'abc hallodef' == latexStripper.stripString('abc {hallo}def')
		assert 'abchallo def' == latexStripper.stripString('abc{hallo} def')
	}
	
	@Test
	void bracketsWithLinebreakRemoved() {
		assert '\n' == latexStripper.stripString('{\n}')
	}
	
	@Test
	void doubleBracketsRemoved() {
		assert '' == latexStripper.stripString('{{')
	}
	
	@Ignore
	@Test
	void literalBracketsKept() {
		assert '\\}' == latexStripper.stripString('\\}')
	}
	
	

}
