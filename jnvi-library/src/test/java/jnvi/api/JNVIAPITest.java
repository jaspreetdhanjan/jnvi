package jnvi.api;

import org.junit.BeforeClass;
import org.junit.Test;
import uk.ac.hud.jnvi.api.JNVIAPI;
import uk.ac.hud.jnvi.memory.DirectFloat;
import uk.ac.hud.jnvi.util.SharedLibrary;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JNVIAPITest {
	@BeforeClass
	public static void beforeClass() {
		SharedLibrary.load(true);
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
	public void testNativeMultiplyCorrectness() {
		Random random = new Random();

		final float a0 = random.nextFloat() * random.nextInt(1000);
		final float b0 = random.nextFloat() * random.nextInt(1000);
		final float c0 = random.nextFloat() * random.nextInt(1000);
		final float d0 = random.nextFloat() * random.nextInt(1000);

		final float a1 = random.nextFloat() * random.nextInt(1000);
		final float b1 = random.nextFloat() * random.nextInt(1000);
		final float c1 = random.nextFloat() * random.nextInt(1000);
		final float d1 = random.nextFloat() * random.nextInt(1000);

		final DirectFloat vector0 = new DirectFloat(4);
		vector0.set(0, a0);
		vector0.set(1, b0);
		vector0.set(2, c0);
		vector0.set(3, d0);

		final DirectFloat vector1 = new DirectFloat(4);
		vector1.set(0, a1);
		vector1.set(1, b1);
		vector1.set(2, c1);
		vector1.set(3, d1);

		final DirectFloat resultVector = new DirectFloat(4);

		JNVIAPI.nativeMultiply(vector0.getAddress(), vector1.getAddress(), resultVector.getAddress(), 4);

		assertEquals(a0 + " * " + a1 + " calculation should be correct.", a0 * a1, resultVector.get(0), 0.0f);
		assertEquals(b0 + " * " + b1 + " calculation should be correct.", b0 * b1, resultVector.get(1), 0.0f);
		assertEquals(c0 + " * " + c1 + " calculation should be correct.", c0 * c1, resultVector.get(2), 0.0f);
		assertEquals(d0 + " * " + d1 + " calculation should be correct.", b0 * d1, resultVector.get(3), 0.0f);

		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
}