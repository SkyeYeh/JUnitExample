package com.skye.junitExample.junit3;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.skye.junitExample.Calculator;

public class CalculatorTest extends TestCase {
	private Calculator calculator;

	@Override
	protected void setUp() {
		calculator = new Calculator();
	}

	@Override
	protected void tearDown() {
		calculator = null;
	}

	public void testPlus() {
		int expected = 5;
		int result = calculator.plus(3, 2);
		assertEquals(expected, result);
	}

	public void testMinus() {
		int expected = 1;
		int result = calculator.minus(3, 2);
		assertEquals(expected, result);
	}
	
	public void testABC() {
		fail("尚未撰寫");
	}

	public static void main(String[] args) {
		TestRunner.run(CalculatorTest.class);
	}
}
