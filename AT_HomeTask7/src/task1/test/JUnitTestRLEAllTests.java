package task1.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JUnitTestRLECode.class, JUnitTestRLEDecodeNegative.class, JUnitTestRLEDecodePositive.class })
public class JUnitTestRLEAllTests {

}
