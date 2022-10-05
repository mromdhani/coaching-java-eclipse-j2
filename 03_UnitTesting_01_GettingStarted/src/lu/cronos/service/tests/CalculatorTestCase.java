package lu.cronos.service.tests;

import static org.junit.Assert.assertEquals;
import lu.cronos.service.Calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTestCase {

	private Calculator calculator;
	
	@Before
	public void setUp() throws Exception {
		 calculator = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		 calculator = null;
	}

	@Test
	public final void testMultiply() {
		
		// Arrange
		int a = 11;
		int b = 2;
		int expected = 22;
		
		// Act
		int actual = calculator.multiply(a,b);
		
		// Assert 
		 assertEquals(expected, actual);
	}
	
	@Test
	public final void testDivide_Regular() {
		
		// Arrange
		int a = 44;
		int b = 4;
		int expected = 11;
		
		// Act
		int actual = calculator.divide(a,b);
		
		// Assert 
		 assertEquals(actual, expected);
	}
	
	@Test(expected=ArithmeticException.class)
	public final void testDivide_Exceptional() {
		
		// Arrange
		int a = 44;
		int b = 0;
				
		// Act
		int actual = calculator.divide(a,b);
		
		// Assert 
		// assertEquals(actual, expected);
	}

}
