package uk.ac.hud.jnvi.benchmark;

import org.junit.BeforeClass;
import org.junit.Test;
import uk.ac.hud.jnvi.SharedLibrary;
import uk.ac.hud.jnvi.api.JNVIAPI;
import uk.ac.hud.jnvi.memory.DirectFloat;

import java.util.Random;

public class LinearBenchmarks {
	private static final int ITERATIONS = 1_000_000;

	private final Random random = new Random();

	@BeforeClass
	public static void beforeClass() {
		SharedLibrary.load(false);
	}

	@Test
	public void benchmarkLinearOffHeapJni() {
		long totalTime = 0;

		DirectFloat a = new DirectFloat(8);
		DirectFloat b = new DirectFloat(8);
		DirectFloat c = new DirectFloat(8);

		for (int i = 0; i < ITERATIONS; i++) {
			DirectFloat.set(a, new float[]{random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat()});
			DirectFloat.set(b, new float[]{random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat()});

			long time = System.nanoTime();
			JNVIAPI.nativeMultiply(a.getAddress(), b.getAddress(), c.getAddress());
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
			multiply(a, b, c);
			time = System.nanoTime() - time;
			totalTime += time;
		}

		System.out.print("Average calculation time took " + totalTime / ITERATIONS + " nanos");
	}

	private static void multiply(float[] a, float[] b, float[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] * b[i];
		}
	}
}