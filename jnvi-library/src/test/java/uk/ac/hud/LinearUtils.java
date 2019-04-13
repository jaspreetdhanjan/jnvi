package uk.ac.hud;

public class LinearUtils {
	private LinearUtils() {
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

	public static double dotProduct(double[] a, double[] b) {
		double dot = 0;
		for (int i = 0; i < b.length; i++) {
			dot += a[i] * b[i];
		}
		return dot;
	}

	public static void add(int[] a, int[] b, int[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = a[i] + b[i];
		}
	}
}