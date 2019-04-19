package uk.ac.hud.jnvi.benchmark;


import uk.ac.hud.jnvi.SharedLibrary;
import uk.ac.hud.jnvi.api.JNVIAPI;
import uk.ac.hud.jnvi.memory.DirectFloat;

import java.util.Random;

/**
 * This test case is concerned only with the efficiency of the JNVI API.
 * <p>
 * -XX:-UseSuperWord
 */

public class LinearBenchmarks {
	private static final int ITERATIONS = 100;
	
	private final Random random = new Random();
	
	//	@BeforeClass
	public static void beforeClass() {
		SharedLibrary.load();
	}
	
	private int getVectorLength() {
		return 256;
	}
	
	//	@Test
	public void benchmarkMultiplyJNVI() {
		long totalTime = 0;
		
		DirectFloat a = new DirectFloat(getVectorLength());
		DirectFloat b = new DirectFloat(getVectorLength());
		DirectFloat c = new DirectFloat(getVectorLength());
		
		for (int i = 0; i < ITERATIONS; i++) {
			DirectFloat.set(a, getRandomFloatArray());
			DirectFloat.set(b, getRandomFloatArray());
			
			long time = System.nanoTime();
			{
//				JNVIAPI.sqrt(JNVIAPI.TYPE_FLOAT, a.getAddress(), c.getAddress(), getVectorLength());
				JNVIAPI.mul(JNVIAPI.TYPE_FLOAT, a.getAddress(), b.getAddress(), c.getAddress(), getVectorLength());
			}
			time = System.nanoTime() - time;
			totalTime += time;
		}
		
		a.destroy();
		b.destroy();
		c.destroy();
		
		System.out.println("Average JNVI calculation time took " + totalTime / ITERATIONS + " nanos, total time took " + totalTime);
	}
	
	private float[] getRandomFloatArray() {
		float[] arr = new float[getVectorLength()];
		for (int i = 0; i < getVectorLength(); i++) {
			arr[i] = random.nextFloat() * random.nextInt();
		}
		return arr;
	}
	
	//	@Test
	public void benchmarkMultiplyLinear() {
		long totalTime = 0;
		
		for (int i = 0; i < ITERATIONS; i++) {
			float[] a = getRandomFloatArray();
			float[] b = getRandomFloatArray();
			float[] c = new float[getVectorLength()];
			
			long time = System.nanoTime();
			{
//				TestUtils.mul(a, b, c);
			}
			time = System.nanoTime() - time;
			totalTime += time;
		}
		
		System.out.println("Average Java calculation time took " + totalTime / ITERATIONS + " nanos, total time took " + totalTime);
	}
}