package uk.ac.hud.jnvi.benchmark;

import java.util.Random;

public interface BenchmarkRequirement {
	Random RANDOM = new Random();
	
	default int getVectorLength() {
		return 256;
	}
	
	default float[] getRandomFloatArray() {
		final int vectorLength = getVectorLength();
		
		float[] arr = new float[vectorLength];
		for (int i = 0; i < vectorLength; i++) {
			arr[i] = RANDOM.nextInt() * RANDOM.nextFloat();
		}
		return arr;
	}
	
	void setup();
	
	void tearDown();
	
	// Tests

//	void multiplyVectors();

//	void divideVectors();
}