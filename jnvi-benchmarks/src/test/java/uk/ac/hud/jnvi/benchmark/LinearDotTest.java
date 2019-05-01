package uk.ac.hud.jnvi.benchmark;

import java.util.Random;

public class LinearDotTest {
	private static final int N = 256;
	
	public float dotProduct(float[] a, float[] b) {
		float dot = 0;
		for (int i = 0; i < N; i++) {
			dot += a[i] * b[i];
		}
		return dot;
	}
	
	public static void main(String[] args) {
		LinearDotTest d = new LinearDotTest();
		
		float[] a = new float[N];
		float[] b = new float[N];
		
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			a[i] = random.nextFloat() * random.nextInt();
			b[i] = random.nextFloat() * random.nextInt();
		}
		
		float value = d.dotProduct(a, b);
		
		System.out.println(value);
	}
}