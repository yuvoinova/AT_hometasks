package task1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import task1.source.RLEDataCompression;

public class JUnitTestRLEDecodeNegative {

	@Test (expected=IllegalArgumentException.class)
	public void testDecodeGeneralNegative() {
		RLEDataCompression.decode("A");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDecodeNegativeEndsWithDigits() {
		RLEDataCompression.decode("4A3a6B21");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDecodeNegativeLetterAfterBackslash() {
		RLEDataCompression.decode("4A3a\\y");
	}

}
