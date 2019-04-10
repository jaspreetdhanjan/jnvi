package uk.ac.hud.jnvi.benchmark;

import org.junit.BeforeClass;
import org.junit.Test;
import uk.ac.hud.LinearUtils;
import uk.ac.hud.jnvi.SharedLibrary;
import uk.ac.hud.jnvi.api.JNVIAPI;
import uk.ac.hud.jnvi.memory.DirectFloat;

import java.util.Random;

/**
 * This test case is concerned only with the efficiency of the JNVI API.
 */

public class LinearBenchmarks {
	private static final int ITERATIONS = 1_000_000;

	private final Random random = new Random();

	@BeforeClass
	public static void beforeClass() {
		SharedLibrary.load();
	}

//	public void compareTest

	@Test
	public void benchmarkLinearOffHeapJni() {
		long totalTime = 0;

		DirectFloat a = new DirectFloat(8);
		DirectFloat b = new DirectFloat(8);
		DirectFloat c = new DirectFloat(8);

		for (int i = 0; i < ITERATIONS; i++) {
			DirectFloat.set(a, random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat());
			DirectFloat.set(b, random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat());

			long time = System.nanoTime();
			{
				JNVIAPI.add(JNVIAPI.JNVI_FLOAT_TYPE, a.getAddress(), b.getAddress(), c.getAddress());
			}
			time = System.nanoTime() - time;
			totalTime += time;
		}

		a.destroy();
		b.destroy();
		c.destroy();

		System.out.print("Average calculation time took " + totalTime / ITERATIONS + " nanos");
	}

	@Test
	public void benchmarkLinearJava() {
		long totalTime = 0;

		for (int i = 0; i < ITERATIONS; i++) {
			float[] a = {random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat()};
			float[] b = {random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat()};
			float[] c = new float[a.length];

			long time = System.nanoTime();
			{
				LinearUtils.mul(a, b, c);
			}
			time = System.nanoTime() - time;
			totalTime += time;
		}

		System.out.print("Average calculation time took " + totalTime / ITERATIONS + " nanos");
	}
}