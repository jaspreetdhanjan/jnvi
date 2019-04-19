package uk.ac.hud;

import java.util.Random;

public final class TestUtils {
	private TestUtils() {
	}
	
	public static float getRandomFloat(Random random) {
		return random.nextFloat() * random.nextInt(46468);
	}
	
	public static float[] getRandomFloatArray(Random random, int size) {
		float[] arr = new float[size];
		for (int i = 0; i < size; i++) {
			arr[i] = getRandomFloat(random);
		}
		return arr;
	}
	
	public static void add(float[] a, float[] b, float[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] + b[i];
		}
	}
	
	public static void sub(float[] a, float[] b, float[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] - b[i];
		}
	}
	
	public static void mul(float[] a, float[] b, float[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] * b[i];
		}
	}
	
	public static void div(float[] a, float[] b, float[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] / b[i];
		}
	}
	
	public static void add(double[] a, double[] b, double[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] + b[i];
		}
	}
	
	public static void sub(double[] a, double[] b, double[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] - b[i];
		}
	}
	
	public static void mul(double[] a, double[] b, double[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] * b[i];
		}
	}
	
	public static void div(double[] a, double[] b, double[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] / b[i];
		}
	}
	
	public static void rsqrt(float[] a, float[] b) {
		for (int i = 0; i < b.length; i++) {
			b[i] = 1.0f / (float) Math.sqrt(a[i]);
		}
	}

}