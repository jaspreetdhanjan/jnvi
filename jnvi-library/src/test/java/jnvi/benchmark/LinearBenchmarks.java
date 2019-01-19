package jnvi.benchmark;

import org.junit.BeforeClass;
import org.junit.Test;
import uk.ac.hud.jnvi.api.JNVIAPI;
import uk.ac.hud.jnvi.memory.DirectFloat;
import uk.ac.hud.jnvi.util.SharedLibrary;

import java.util.Random;

public class LinearBenchmarks {
	private final Random random = new Random();

	@BeforeClass
	public static void beforeClass() {
		SharedLibrary.load(false);
	}

	@Test
	public void benchmarkLinearOffHeapJni() {
		long totalTime = 0;
		final int iterations = 1000000;

		DirectFloat a = new DirectFloat(8);
		DirectFloat b = new DirectFloat(8);
		DirectFloat c = new DirectFloat(8);

		for (int i = 0; i < iterations; i++) {
			DirectFloat.set(a, new float[]{random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat()});
			DirectFloat.set(b, new float[]{random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat()});

			long time = System.nanoTime();
			JNVIAPI.nativeMultiply(a.getAddress(), b.getAddress(), c.getAddress(), 8);
			time = System.nanoTime() - time;
			totalTime += time;
		}

		a.destroy();
		b.destroy();
		c.destroy();

		System.out.print("Average calculation time took " + totalTime / iterations + " nanos");
	}

	@Test
	public void benchmarkLinearJava() {
		long totalTime = 0;
		final int iterations = 1000000;

		for (int i = 0; i < iterations; i++) {
			float[] a = {random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat()};
			float[] b = {random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat()};

			long time = System.nanoTime();
			float[] c = multiply(a, b);
			time = System.nanoTime() - time;
			totalTime += time;
		}

		System.out.print("Average calculation time took " + totalTime / iterations + " nanos");
	}

	private static float[] multiply(float[] a, float[] b) {
		float[] c = new float[a.length];
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] * b[i];
		}
		return c;
	}

	/*
	@Test
	public void benchmarkLinearHeapJNI() {
		long totalTime = 0;
		final int iterations = 1000000;

		for (int i = 0; i < iterations; i++) {
			float[] a = {random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat()};
			float[] b = {random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat(), random.nextFloat()};

			long time = System.nanoTime();
//			float[] c = JNVIAPI.multiply(a, b);
			time = System.nanoTime() - time;
			totalTime += time;
		}

		System.out.print("Average calculation time took " + totalTime / iterations + " nanos");
	}*/
}