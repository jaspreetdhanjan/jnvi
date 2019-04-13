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

	private float[] getRandomVectorData(int vectorLength) {
		float[] arr = new float[vectorLength];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextFloat() * random.nextInt();
		}
		return arr;
	}

	@Test
	public void benchmarkMultiplyJNVI() {
		final int vectorLength = 128;
		long totalTime = 0;

		DirectFloat a = new DirectFloat(vectorLength);
		DirectFloat b = new DirectFloat(vectorLength);
		DirectFloat c = new DirectFloat(vectorLength);

		for (int i = 0; i < ITERATIONS; i++) {
			DirectFloat.set(a, getRandomVectorData(vectorLength));
			DirectFloat.set(b, getRandomVectorData(vectorLength));

			long time = System.nanoTime();
			{
				JNVIAPI.add(JNVIAPI.TYPE_FLOAT, a.getAddress(), b.getAddress(), c.getAddress(), 8);
			}
			time = System.nanoTime() - time;
			totalTime += time;
		}

		a.destroy();
		b.destroy();
		c.destroy();

		System.out.println("Average calculation time took " + totalTime / ITERATIONS + " nanos");
	}

	@Test
	public void benchmarkMultiplyLinear() {
		final int vectorLength = 128;
		long totalTime = 0;

		for (int i = 0; i < ITERATIONS; i++) {
			float[] a = getRandomVectorData(vectorLength);
			float[] b = getRandomVectorData(vectorLength);
			float[] c = new float[vectorLength];

			long time = System.nanoTime();
			{
				LinearUtils.mul(a, b, c);
			}
			time = System.nanoTime() - time;
			totalTime += time;
		}

		System.out.println("Average calculation time took " + totalTime / ITERATIONS + " nanos");
	}
}