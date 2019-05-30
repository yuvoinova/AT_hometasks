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
public class JUnitTestRLECode {
	private String expected;
	private String value;

	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { "4A3a6B\\\\\\1\\2", "AAAAaaaBBBBBB\\12" }, { "1A3a2B\\2", "AaaaBB2" },
				{ "1A3a2B\\\\\\\\\\2", "AaaaBB\\\\2" } });
	}

	public JUnitTestRLECode(String expected, String value) {
		this.expected = expected;
		this.value = value;
	}

	@Test
	public void testCode() {
		assertEquals(expected, RLEDataCompression.code(value));
	}
}
