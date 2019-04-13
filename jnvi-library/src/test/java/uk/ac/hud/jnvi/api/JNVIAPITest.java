package uk.ac.hud.jnvi.api;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import uk.ac.hud.jnvi.SharedLibrary;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This test case is concerned only with the correctness of the JNVI API.
 */

public class JNVIAPITest implements CorrectnessTest {
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	private Random random = new Random();

	private Collection<CorrectnessTest> correctnessTests = Arrays.asList(
//			new DoubleCorrectnessTest(collector, random),
			new FloatCorrectnessTest(collector, random)
//			new IntCorrectnessTest(collector, random)
	);

	@BeforeClass
	public static void beforeClass() {
		SharedLibrary.load();
	}

	@Test
	public void testApiVersion() {
		final int version = JNVIAPI.getVersion();

		assertEquals("Version should be 1", version, 1);
	}

	@Test
	public void testIsSupported() {
		final boolean supportExists = JNVIAPI.isSupported();

		assertTrue("Should be supported to run these tests.", supportExists);
	}

	@Test
	public void testAddCorrectness() {
		correctnessTests.forEach(CorrectnessTest::testAddCorrectness);
	}

	@Test
	public void testSubCorrectness() {
		correctnessTests.forEach(CorrectnessTest::testSubCorrectness);
	}

	@Test
	public void testMulCorrectness() {
		correctnessTests.forEach(CorrectnessTest::testMulCorrectness);
	}

	@Test
	public void testDivCorrectness() {
		correctnessTests.forEach(CorrectnessTest::testDivCorrectness);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		JNVIAPI.add((byte) 4, 2552, 2524, 6553, 5);
	}
}