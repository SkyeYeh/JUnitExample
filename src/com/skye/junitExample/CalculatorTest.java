package com.skye.junitExample;

public class CalculatorTest extends TestCase {
	private Calculator calculator;

	public CalculatorTest() {
	}

	public CalculatorTest(String string) {
		super(string);
	}

	@Override
	protected void setUp() {
		calculator = new Calculator();
	}

	@Override
	protected void tearDown() {
		calculator = null;
	}

	public void testPlus() {
		calculator = new Calculator();
		int expected = 3;
		int result = calculator.plus(1, 2);
		Assert.assertEquals(expected, result);
	}

	public void testMinus() {
		calculator = new Calculator();
		int expected = 1;
		int result = calculator.minus(3, 2);
		Assert.assertEquals(expected, result);
	}

	public static void main(String[] args) {
		TestRunner.run(CalculatorTest.class);
	}
}
