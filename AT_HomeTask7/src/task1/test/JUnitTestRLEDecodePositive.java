package task1.test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import task1.source.RLEDataCompression;

@RunWith(value = Parameterized.class)
public class JUnitTestRLEDecodePositive {
	private String expected;
	private String value;
	
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { {"AAAAaaaBBBBBB\\12","4A3a6B\\\\\\1\\2"}, {"AaaaBB2","1A3a2B\\2"},
				{"AaaaBB\\\\2","1A3a2B\\\\\\\\\\2"} });
	}
	
	public JUnitTestRLEDecodePositive(String expected, String value) {
		this.expected = expected;
		this.value = value;
	}

	@Test
	public void testDecode() {
		assertEquals(expected, RLEDataCompression.decode(value));
	}
	
}
