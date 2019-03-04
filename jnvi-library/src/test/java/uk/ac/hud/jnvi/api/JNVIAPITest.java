package uk.ac.hud.jnvi.api;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import uk.ac.hud.jnvi.SharedLibrary;
import uk.ac.hud.jnvi.memory.DirectFloat;

import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JNVIAPITest {
	@Rule
	public ErrorCollector collector = new ErrorCollector();

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
	public void testNativeMultiplyCorrectness_mm256() {
		Random random = new Random();

		final DirectFloat vector0 = new DirectFloat(8);

		final float a0 = random.nextFloat() * random.nextInt(1000);
		final float b0 = random.nextFloat() * random.nextInt(1000);
		final float c0 = random.nextFloat() * random.nextInt(1000);
		final float d0 = random.nextFloat() * random.nextInt(1000);
		final float e0 = random.nextFloat() * random.nextInt(1000);
		final float f0 = random.nextFloat() * random.nextInt(1000);
		final float g0 = random.nextFloat() * random.nextInt(1000);
		final float h0 = random.nextFloat() * random.nextInt(1000);

		vector0.set(0, a0);
		vector0.set(1, b0);
		vector0.set(2, c0);
		vector0.set(3, d0);
		vector0.set(4, e0);
		vector0.set(5, f0);
		vector0.set(6, g0);
		vector0.set(7, h0);

		final DirectFloat vector1 = new DirectFloat(8);

		final float a1 = random.nextFloat() * random.nextInt(1000);
		final float b1 = random.nextFloat() * random.nextInt(1000);
		final float c1 = random.nextFloat() * random.nextInt(1000);
		final float d1 = random.nextFloat() * random.nextInt(1000);
		final float e1 = random.nextFloat() * random.nextInt(1000);
		final float f1 = random.nextFloat() * random.nextInt(1000);
		final float g1 = random.nextFloat() * random.nextInt(1000);
		final float h1 = random.nextFloat() * random.nextInt(1000);

		vector1.set(0, a1);
		vector1.set(1, b1);
		vector1.set(2, c1);
		vector1.set(3, d1);
		vector1.set(4, e1);
		vector1.set(5, f1);
		vector1.set(6, g1);
		vector1.set(7, h1);

		final DirectFloat resultVector = new DirectFloat(8);
		JNVIAPI.nativeMultiply(vector0.getAddress(), vector1.getAddress(), resultVector.getAddress());

		collector.checkThat(a0 + " * " + a1 + " calculation should be correct.", a0 * a1, equalTo(resultVector.get(0)));
		collector.checkThat(b0 + " * " + b1 + " calculation should be correct.", b0 * b1, equalTo(resultVector.get(1)));
		collector.checkThat(c0 + " * " + c1 + " calculation should be correct.", c0 * c1, equalTo(resultVector.get(2)));
		collector.checkThat(d0 + " * " + d1 + " calculation should be correct.", d0 * d1, equalTo(resultVector.get(3)));
		collector.checkThat(e0 + " * " + e1 + " calculation should be correct.", e0 * e1, equalTo(resultVector.get(4)));
		collector.checkThat(f0 + " * " + f1 + " calculation should be correct.", f0 * f1, equalTo(resultVector.get(5)));
		collector.checkThat(g0 + " * " + g1 + " calculation should be correct.", g0 * g1, equalTo(resultVector.get(6)));
		collector.checkThat(h0 + " * " + h1 + " calculation should be correct.", h0 * h1, equalTo(resultVector.get(7)));

		vector0.destroy();
		vector1.destroy();
		resultVector.destroy();
	}
}